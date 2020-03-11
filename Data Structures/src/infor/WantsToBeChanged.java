package infor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WantsToBeChanged {

  /**
   * 
   * @param op
   * @param theMainMap
   * @param sum
   */
  public void performOperation(OperationDefinition op, Map<Long, String> theMainMap,
      OperSummary sum) {
    for (int d = 0; d < op.getOperationDetailsStore().size();) {
      OperationDetail opDetails = op.getOperationDetailsStore().get(d);
      if (opDetails.getOpStatusId() == 1 || opDetails.getOpStatusId() == 3
          || opDetails.getOpStatusId() == 4) {
        sum.setOpCond(true); // 1
        if (opDetails.getRelblkId() != null && opDetails.getOperationsumRefId() != null
            && opDetails.getOperationsumParentId() != null) {
          sum.setIsReliefOperation("Y");
          theMainMap.put(opDetails.getOperationsumId(), "Y");
        }
      } else {
        if (opDetails.getRelblkId() != null && opDetails.getOperationsumRefId() != null
            && opDetails.getOperationsumParentId() != null) {
          sum.setOpCond(true); // 2
          sum.setIsReliefOperation("Y");
          theMainMap.put(opDetails.getOperationsumId(), "Y");
        } else {
          sum.setOpCond(true); // 3
        }
      }
      System.out.println("here");
      break;
    }
  }
  
  /*
   * In the for loop, I noticed that the loop looks like an infinite loop. BUT, I also notice
   * later on in the code there is a break. So I notice the for loop runs exactly once. From there
   * I notice, the initial value of d is set to be 0. Therefore, we are going to do
   * getOperationDetailsStore().get(0). Next, I look at the if-else with the status ID. One thing
   * I noticed in all the branches (ie. all the if statements and inner if statements) is that
   * setIsOpCond(true) is all of them. This is set for all statuses. Next, I noticed both codes,
   * have the same if statement checking for opDetails.getRelblkId() ! = null,
   * opDetails.getOperationsumRefId() != null, and opDetails.getOperationsumParentId() != null,
   * and everything in the if statement is the same. So, regardless of the status, this check is
   * done and we do sum.setIsReliefOperatioN("Y"), and
   * theMainMap.put(opDetails.getOperationsumId(), "Y").
   */
  public void performOperationMine(OperationDefinition opDefinition, Map<Long, String> theMainMap,
      OperSummary sum) {
    int detailId = 0;
    OperationDetail opDetails = opDefinition.getOperationDetailsStore().get(detailId);
    sum.setOpCond(true);
    if (opDetails.getRelblkId() != null && opDetails.getOperationsumRefId() != null
        && opDetails.getOperationsumParentId() != null) {
      sum.setIsReliefOperation("Y");
      theMainMap.put(opDetails.getOperationsumId(), "Y");
    }
  }

  /*
   * You are working on a product that has a good test suite. Unfortunately, your CI server was down
   * for several days and when it was restarted the very next test execution failed. Between the
   * last successful test execution and today, there were 300 commits made by developers. It takes
   * 10 minutes to execute tests on a commit. You need to implement a function that returns the
   * first commit id that broke the tests. Your implementation should return response in less than 2
   * hours. You can assume that all commits before the bad commit pass and all commits after fail.
   * 
   * Input: ordered list of commit IDs ([123, 127, 130, 137,...]) Available API: boolean
   * executeTests(commitId) - runs tests on a given commit. Returns true if tests pass, false
   * otherwise. Output: single number - first commit id that broke the tests
   * 
   * ----------------------------------------------------------------------
   * 
   * 
   */
  
  /*
   * In this problem, we can't use a naive solution (ie. looping through all commits). It would take
   * way too long. One solution we can use is similar to a binary search solution. It is more of a
   * tweaked version. In this case we don't know what number we are looking for. Binary search is a
   * good solution because it is an O(log n) solution which should fit our time constraints here.
   * The approach to this is we always look for the middle of the current portion of the array.
   * Initially, we look at the entire array, and we pick the middle element. Then, there is two
   * cases:
   * 
   * Case 1: If this commit corresponding to the middle element is a bad commit, we are off to a
   * good start. We've eliminated half of the commits to check over. Next, we set the new middle as
   * the one before our middle index. In other words, we look at the earlier half. From there, we
   * repeat this process replacing the bad commit ID with whichever commit fails.
   * 
   * Case 2: If this commit corresponding to the middle is not a bad commit, we need to look in the
   * later half of the array. In other words, this is middle + 1 to the end. We repeat this process
   * to narrow down the array in half until we reach case 1.
   */
  public int findBadCommit(int[] commitIds) {
    // Sets the bad commit and previous bad commit
    int badCommit = -1;
    
    // Used to indicate which part of the array to look (initially it is the entire array)
    int startIndex = 0;
    int lastIndex = commitIds.length - 1;
    
    while (startIndex <= lastIndex) {
      int middle = (startIndex + lastIndex) / 2;
      
      // If the tests fail
      if (executeTests(commitIds[middle]) == false) {
        // Case 1: Set the bad commit and look in the earlier half of commits
        badCommit = commitIds[middle];
        lastIndex = middle - 1;
      } else {
        // If bad commit is never set, we look on the later half of the commits
        if (badCommit == -1) {
          startIndex = middle + 1;
        } else {
          return badCommit;
        }
      }      
    }
    // Not found (no bad commit!)
    return badCommit;
  }
  
  public static void main(String[] args) {
    String[] arrA = {"hi"};
    String[] arrB = {"bye"};

    isInBoth("hi", arrA, arrB);
  }
  
  public static boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
    boolean found = false;
    Set<String> values = new HashSet<>();
    
    if (arrayA.length == 0 || arrayB.length == 0) {
      return found;
    }
    
    boolean isContainedInA = addToValues(values, arrayA, value)
    
    if (!isContainedInA) {
      return found;
    }
    
    boolean isContainedInB = addToValues(values, arrayB, value);
      
    if (!isContainedInB) {
      return found;
    } else {
      found = true;
    }
    
    return found;
  }
  
  private static boolean addToValues(Set<String> values, String[] arr, String value) {
    boolean isContainedIn = false;
    // O(n) operation to add all array characters
    for (String somethingInArr : arr) {
      if (somethingInArr.equals(value)) {
        isContainedIn = true;
      }
      values.add(somethingInArr);
    }
    return isContainedIn;
  }

}