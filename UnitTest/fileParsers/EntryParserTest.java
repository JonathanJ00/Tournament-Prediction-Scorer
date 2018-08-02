package fileParsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Utilities.FormatType;
import dataStorage.Entry;
import dataStorage.TournamentFormat;
import results.IResult;
import rounds.IRound;

public class EntryParserTest {
	
private EntryParser testParser;
private TournamentFormat tournament;
	
	@Before
	public void setUp() {
		tournament = new TournamentFormat();
		
		tournament.addRound("Qualifying", FormatType.GROUP, 1, 2, 8, 2);
		tournament.addRound("Quarter Finals", FormatType.KNOCKOUT, 2, 8, 0, 0);
		tournament.addRound("Semi Finals", FormatType.KNOCKOUT, 4, 4, 0, 0);
		tournament.addRound("Final", FormatType.KNOCKOUT, 6, 2, 0, 0);
		tournament.addRound("Winner", FormatType.KNOCKOUT, 8, 1, 0, 0);
		tournament.addRound("Tiebreak", FormatType.TIEBREAK, 0, 0, 0, 0);
		
		testParser = new EntryParser(tournament);
	}
	
	@Test
	public void testExampleFile() {
		Entry entry = null;
		String currentPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		String testFilePath = currentPath.concat("\\exampleFiles\\Entry_Sheet.xlsx");
		File file = new File(testFilePath);
		
		try {
			entry = testParser.parseEntry(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<IRound> rounds = entry.getRounds();

		assertEquals(6, rounds.size());
		
		IRound round = entry.getRound("Qualifying");
		List<String> expectedTeams = Arrays.asList("A1", "A2", "B1", "B2", "C1", "C2", "D1", "D2", "E1", "E2", "F1", "F2", "G1", "G2", "H1", "H2");
		
		assertNotNull(round);
		assertEquals(FormatType.GROUP, round.getFormat());
		
		IResult result = round.getResult();
		List<String> actualTeams = result.getTeams();
		
		assertEquals(FormatType.GROUP, result.getFormat());
		assertEquals(16, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
		
		round = entry.getRound("Quarter Finals");
		expectedTeams = Arrays.asList("A1", "B2", "C1", "C2", "E2", "F1", "G2", "G1");
		
		assertNotNull(round);
		assertEquals(FormatType.KNOCKOUT, round.getFormat());
		
		result = round.getResult();
		actualTeams = result.getTeams();
		
		assertEquals(FormatType.KNOCKOUT, result.getFormat());
		assertEquals(8, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
		
		round = entry.getRound("Semi Finals");
		expectedTeams = Arrays.asList("A1", "C2", "E2", "F1");
		
		assertNotNull(round);
		assertEquals(FormatType.KNOCKOUT, round.getFormat());
		
		result = round.getResult();
		actualTeams = result.getTeams();
		
		assertEquals(FormatType.KNOCKOUT, result.getFormat());
		assertEquals(4, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
		
		round = entry.getRound("Final");
		expectedTeams = Arrays.asList("A1", "F1");
		
		assertNotNull(round);
		assertEquals(FormatType.KNOCKOUT, round.getFormat());
		
		result = round.getResult();
		actualTeams = result.getTeams();
		
		assertEquals(FormatType.KNOCKOUT, result.getFormat());
		assertEquals(2, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
		
		round = entry.getRound("Winner");
		expectedTeams = Arrays.asList("F1");
		
		assertNotNull(round);
		assertEquals(FormatType.KNOCKOUT, round.getFormat());
		
		result = round.getResult();
		actualTeams = result.getTeams();
		
		assertEquals(FormatType.KNOCKOUT, result.getFormat());
		assertEquals(1, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
		
		round = entry.getRound("Tiebreak");
		expectedTeams = Arrays.asList("32.0");
		
		assertNotNull(round);
		assertEquals(FormatType.TIEBREAK, round.getFormat());
		
		result = round.getResult();
		actualTeams = result.getTeams();
		
		assertEquals(FormatType.TIEBREAK, result.getFormat());
		assertEquals(1, actualTeams.size());
		assertTrue(actualTeams.containsAll(expectedTeams));
	}
}
