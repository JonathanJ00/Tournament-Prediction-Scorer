package fileParsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.FormatType;
import Utilities.RoundDetails;
import dataStorage.Entry;
import dataStorage.TournamentFormat;
import results.IResult;
import results.ResultFactory;
import rounds.IRound;
import rounds.RoundFactory;

public class EntryParser {
	private TournamentFormat format;
	
	public EntryParser(TournamentFormat format) {
		this.format = format;
	}
	
	public Entry parseEntry(File file) throws IOException {
		Entry entry = new Entry();
		Map<String, Integer> columnIndexes = new HashMap<>();
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		
		Row firstRow = iterator.next();
		columnIndexes = readFirstEntryLine(firstRow);
		
		Set<String> columns = columnIndexes.keySet();
		
		Map<Integer, IRound> rounds = new HashMap<Integer, IRound>();
		Map<Integer, IResult> results = new HashMap<Integer, IResult>();
		for (String column: columns) {
			RoundDetails details = format.getDetails(column);
			
			IRound thisRound = RoundFactory.createRound(details.getType());
			thisRound.setName(column);
			rounds.put(columnIndexes.get(column), thisRound);
			
			IResult thisResult = ResultFactory.createResult(details.getType());
			results.put(columnIndexes.get(column), thisResult);
		}
		
		Set<Integer> indexes = rounds.keySet();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				if (indexes.contains(columnIndex)) {
					IResult thisResult = results.get(columnIndex);
					String teamName = nextCell.getStringCellValue().trim();
					
					if ((thisResult.getFormat() == FormatType.GROUP) && (teamName.startsWith("Group"))) {
						break;
					} 
					else {
						thisResult.addTeam(teamName);
					}
				}
			}
		}
		
		workbook.close();
		inputStream.close();
		
		for (Integer index: indexes) {
			IRound thisRound = rounds.get(index);
			thisRound.setResult(results.get(index));
			entry.addRound(thisRound);
		}
		
		return entry;
	}
	
	private Map<String, Integer> readFirstEntryLine(Row firstRow) {
		Map<String, Integer> roundList = new HashMap<String, Integer>();
		
		Iterator<Cell> cellIterator = firstRow.cellIterator();
		
		while (cellIterator.hasNext()) {
			Cell nextCell = cellIterator.next();
			String name = nextCell.getStringCellValue();
			
			if (!name.equals("")) {
				int columnIndex = nextCell.getColumnIndex();
				
				roundList.put(name, new Integer(columnIndex));
			}
		}
		
		return roundList;
	}
}
