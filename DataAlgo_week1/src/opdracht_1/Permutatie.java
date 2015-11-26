package opdracht_1;

import java.util.Arrays;
import java.util.Random;

public class Permutatie {


	/**
	 * Vul een voor een de elementen a[0] tot a[N-1] van de array a Om element
	 * a[i] te vullen, genereer je net zo lang een random getal totdat er een is
	 * gevonden die niet gelijk is aan a[0] t/m a[i-1].
	 * 
	 */
	public long permutate_1(int[] arr) {
		Random random = new Random();
		long start = System.currentTimeMillis();
		for (int i = 0; < arr.length;i++) {
			int guess = random.nextInt(arr.length);
			for (int x = 0; x < i; x++) {
				if(guess == arr[x]){
					guess = random.nextInt(arr.length);
					 
				}
			}
				arr[i] = guess;
		}
		
		return System.currentTimeMillis() - start;

	}

	/**
	 *Analoog aan algoritme 1, maar hou nu een extra array used bij
 	  Wanneer een random getal r in array a wordt gezet, zet dan ook used[r] op true. 
 	  Bij het vullen van a[i] kunnen we nu dus direct zien of het gegenereerde random getal al gebruikt is of niet (i.p.v. alle plaatsen a[0] t/m a[i-1] langs te lopen).
	 */
	public long permutate_2(int[] arr){
		boolean[] check = new boolean[arr.length]; // Create an array with the same size of the integer array
		Random random = new Random(); // Random object to generate the numbers
		long counter = 0;
		long start = System.currentTimeMillis();
		for(int i = 0;i < arr.length;i++){ // iterate    O(N)
			int guess;
			while(check[guess = random.nextInt(arr.length)]){
				++counter;
			};
			check[guess] = true;
			arr[i] = guess;
		}
		System.out.println(counter);
		return System.currentTimeMillis() - start;
	}
	
	
	/**
	 * 
	 */
	public long permutate_3(int[] arr){
		Random random = new Random(); // Random object to generate the numbers
		long start = System.currentTimeMillis();
		arr[0] = 0; // (First number nothing to swap with!);
		for(int i = 1;i < arr.length;i++){ // iterate
			arr[i] = i;
			int swap = random.nextInt(i);
			int remember = arr[swap];
			arr[swap] = arr[i];
			arr[i] = remember;
			
			
		}
		return System.currentTimeMillis() - start;
	}

}
