package fileParsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Utilities.FormatType;
import Utilities.RoundDetails;
import dataStorage.TournamentFormat;

public class OrganiserParserTest {

	private OrganiserParser testParser;
	
	@Before
	public void setUp() {
		testParser = new OrganiserParser();
	}
	
	@Test
	public void testExampleFile() {
		TournamentFormat format = null;
		String currentPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
		String testFilePath = currentPath.concat("\\exampleFiles\\Organiser_Sheet.xlsx");
		File file = new File(testFilePath);
		
		try {
			format = testParser.parseFormat(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> rounds = format.getRounds();
		
		assertEquals(6, rounds.size());
		
		assertTrue(rounds.contains("Qualifying"));
		assertTrue(rounds.contains("Quarter Finals"));
		assertTrue(rounds.contains("Semi Finals"));
		assertTrue(rounds.contains("Final"));
		assertTrue(rounds.contains("Winner"));
		
		RoundDetails details = format.getDetails("Qualifying");
		
		assertEquals(FormatType.GROUP, details.getType());
		assertEquals(8, details.getNumGroups());
		assertEquals(2, details.getNumTeams());
		assertEquals(1, details.getScore());
		assertEquals(2, details.getBonus());
		
		details = format.getDetails("Quarter Finals");
		
		assertEquals(FormatType.KNOCKOUT, details.getType());
		assertEquals(0, details.getNumGroups());
		assertEquals(8, details.getNumTeams());
		assertEquals(2, details.getScore());
		assertEquals(0, details.getBonus());
		
		details = format.getDetails("Semi Finals");
		
		assertEquals(FormatType.KNOCKOUT, details.getType());
		assertEquals(0, details.getNumGroups());
		assertEquals(4, details.getNumTeams());
		assertEquals(4, details.getScore());
		assertEquals(0, details.getBonus());
		
		details = format.getDetails("Final");
		
		assertEquals(FormatType.KNOCKOUT, details.getType());
		assertEquals(0, details.getNumGroups());
		assertEquals(2, details.getNumTeams());
		assertEquals(6, details.getScore());
		assertEquals(0, details.getBonus());
		
		details = format.getDetails("Winner");
		
		assertEquals(FormatType.KNOCKOUT, details.getType());
		assertEquals(0, details.getNumGroups());
		assertEquals(1, details.getNumTeams());
		assertEquals(8, details.getScore());
		assertEquals(0, details.getBonus());
		
		details = format.getDetails("Tiebreak");
		
		assertEquals(FormatType.TIEBREAK, details.getType());
		assertEquals(0, details.getNumGroups());
		assertEquals(0, details.getNumTeams());
		assertEquals(0, details.getScore());
		assertEquals(0, details.getBonus());
	}
}
