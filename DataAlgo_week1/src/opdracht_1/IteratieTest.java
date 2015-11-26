package opdracht_1;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class IteratieTest {
	
	private static final int FIRST_ALGORITME = 1;
	private static final int SECOND_ALGORITME = 2;
	private static final int THIRD_ALGORITME = 3;

	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////    Validate tests   ///////////////  ///   ///  validation  ///////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void validateGenerate_1(){
		Permutatie iterate = new Permutatie(); 
		int[] first = new int[100]; // Test 1000 numbers using algoritme 1
		int[] second = new int[100]; // Test 1000 numbers using algoritme 1
		int[] third = new int[100]; // Test 1000 numbers using algoritme 1
		iterate.permutate_1(first);
		iterate.permutate_2(second);
		iterate.permutate_3(third);
		
		HashSet<Integer> first_test = new HashSet<>();
		HashSet<Integer> second_test = new HashSet<>();
		HashSet<Integer> third_test = new HashSet<>();
		
		/*
		 *  Inserting all values of the permutated arrays into the hashset. 
		 */
		for(int i : first){          
			first_test.add(i);
		}
		for(int i : second){
			second_test.add(i);
		}
		for(int i : third){
			third_test.add(i);
		}
		/*
		 * If the size of the hastset which contains only unique elements differs from the array,it means that the algoritme messed up
		 */
	
		Assert.assertEquals(first.length, first_test.size());
		Assert.assertEquals(second.length, second_test.size());
		Assert.assertEquals(third.length, third_test.size());
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////    Time test   ///////////////  ///   ///   time       ///////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Algoritme 1 met N = 5.000, 10.000, 20.000, 50.000, 100.000;  
	 */
	@Test
	public void testGenerate_1() {
		ArrayList<Integer> toBeTested = new ArrayList<Integer>();
		/*
		 * Add initial values to be tested
		 */
		toBeTested.add(10);
		toBeTested.add(5000); // 5000
		toBeTested.add(10000); // 10.000
		toBeTested.add(20000); // 20.000
		toBeTested.add(40000); // 40.000
		toBeTested.add(50000); // 50.000
		toBeTested.add(80000); // 80.000
		toBeTested.add(100000); // 100.000
		
		System.out.println("\n START ALGORITME 1 TEST \n");
		time(toBeTested,FIRST_ALGORITME);
		System.out.println("\nSTOP ALGORITME 1 TEST\n");
	}
	
	/**
	 * Algoritme 2 met N = 100.000, 500.000, 1.000.000, 5.000.000, 10.000.000;
	 */
	@Test
	public void testGenerate_2(){
		ArrayList<Integer> toBeTested = new ArrayList<Integer>();
		/*
		 * Add initial values to be tested
		 */
		toBeTested.add(100000); // 100.000
		toBeTested.add(500000); // 500.000
		toBeTested.add(1000000); // 1.000.000
		toBeTested.add(5000000); // 5.000.000
		toBeTested.add(10000000); // 10.000.000
		System.out.println("\n START ALGORITME 2 TEST \n");
		time(toBeTested,SECOND_ALGORITME);
		System.out.println("\nSTOP ALGORITME 2 TEST\n");
	}
	
	/**
	 * Algoritme 3 met N = 5.000.000, 10.000.000, 20.000.000, 40.000.000, 80.000.000.
	 */
	@Test
	public void testGenerate_3(){
		ArrayList<Integer> toBeTested = new ArrayList<Integer>();
		/*
		 * Add initial values to be tested
		 */
		toBeTested.add(5000000); // 5.000.000
		toBeTested.add(10000000);//10.000.000
		toBeTested.add(20000000);//20.000.000
		toBeTested.add(40000000);//40.000.000
		toBeTested.add(80000000);//80.000.000
		System.out.println("\n START ALGORITME 3 TEST \n");
		time(toBeTested,THIRD_ALGORITME);
		System.out.println("\nSTOP ALGORITME 3 TEST\n");
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////    Helper Methods   ///////////////  ///   ///   Time       ///////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * Displays the time the algoritmes take for element N
	 */
	public void time(ArrayList<Integer> toBeTested,int type){
		Permutatie permutator = new Permutatie();
		long time;
		for(int n : toBeTested){
			int[] arr = new int[n];
			if(type == FIRST_ALGORITME){
				time = permutator.permutate_1(arr);
			}
			else if(type == SECOND_ALGORITME){
				time = permutator.permutate_2(arr);
			}
			else{
				time = permutator.permutate_3(arr);
			}
			System.out.println("For input " + n + " it took : "+  time + "ms");
		}
	}
	


}
