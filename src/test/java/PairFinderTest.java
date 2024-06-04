
import com.interview.task.pair.finder.EmployeePair;
import com.interview.task.pair.finder.PairFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class PairFinderTest {
    
    private final PairFinder pf = new PairFinder();
    
    @Test
    public void test_basic_csv_1() throws Exception {
       Path testFilePath = Paths.get("src", "test", "resources", "test-1.csv");
       List<EmployeePair> result = pf.determineEmployeePairs(testFilePath);
       assertEquals("Expected one result", 1, result.size());
       
       EmployeePair ep = result.get(0);
       
       assertEquals("Expected project id 10", 12, ep.getProjectId());
       assertEquals("Expected emp id 1", 1, ep.getEmployeeId1());
       assertEquals("Expected emp id 3", 3, ep.getEmployeeId2());
       assertEquals("Expected overlap days 1", 1L, ep.getOverlapDays());
    }
    
    @Test
    public void test_basic_csv_2() throws Exception {
       Path testFilePath = Paths.get("src", "test", "resources", "test-2.csv");
       List<EmployeePair> result = pf.determineEmployeePairs(testFilePath);
       assertEquals("Expected two result", 2, result.size());
       
       EmployeePair ep1 = result.get(0);
       
       assertEquals("Expected project id 10", 10, ep1.getProjectId());
       assertEquals("Expected overlap days 1", 2987L, ep1.getOverlapDays());
       
       EmployeePair ep2 = result.get(1);
       
       assertEquals("Expected project id 12", 12, ep2.getProjectId());
       assertEquals("Expected overlap days 1", 2407L, ep2.getOverlapDays());
    }
}
