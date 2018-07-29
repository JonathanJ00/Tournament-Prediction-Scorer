package fileParsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.FormatType;
import dataStorage.TournamentFormat;

public class OrganiserParser {
	
	public TournamentFormat parseFormat(File file) throws IOException {
		TournamentFormat format = new TournamentFormat();
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		
		Row firstRow = iterator.next();
		
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			String name = null;
			FormatType type = FormatType.GROUP;
			int numGroups = 0;
			int numTeams = 0;
			int points = 0;
			int bonus = 0;
			
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				
				switch (columnIndex) {
				case 0:
					name = nextCell.getStringCellValue();
					break;
				case 2:
					String temp = nextCell.getStringCellValue();
					String[] tokens = temp.split(" ");
					
					switch (tokens[0]) {
					case "Groups":
						type = FormatType.GROUP;
						numGroups = Integer.parseInt(tokens[1]);
						break;
					case "Knockout":
						type = FormatType.KNOCKOUT;
						numGroups = 0;
						break;
					case "Tiebreak":
						type = FormatType.TIEBREAK;
						numGroups = 0;
					}
					
					break;
				case 4:
					numTeams = (int) nextCell.getNumericCellValue();
					break;
				case 6:
					points = (int) nextCell.getNumericCellValue();
					break;
				case 8:
					bonus = (int) nextCell.getNumericCellValue();
					break;
				default :
					break;
				}
			}
			
			format.addRound(name, type, points, numTeams, numGroups, bonus);
		}
		
		workbook.close();
		
		return format;
	}
}
