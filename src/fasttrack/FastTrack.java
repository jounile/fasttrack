package fasttrack;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FastTrack {

	public static void main(String[] args) throws IOException {
		
		Scanner treeScanner = new Scanner(new File("tree.txt"));
		String[] lineValues = null;
		List<String> values = null;
		int totalLikes = 0;
		int valueOflargestValidOne = 0;
		int indexOfLargestValidOne = 0;
		int loop = 0;
		
		while (treeScanner.hasNextLine()) {
			String line = treeScanner.nextLine();
			if(loop == 0){
				System.out.println(line);
			} else {
				lineValues = line.split(" ", -1);
				values = Arrays.asList(lineValues);	
				int[] validIndexes = new int[2];
				int[] validValues = new int[2];
				if(values.size() > 0) {
					validValues[0] = Integer.parseInt(values.get(indexOfLargestValidOne));
					validIndexes[0] = indexOfLargestValidOne;
					if(values.size() > 1) {
						validValues[1] = Integer.parseInt(values.get(indexOfLargestValidOne + 1));
						validIndexes[1] = indexOfLargestValidOne + 1;
					}
				}
				if(validValues[0] > validValues[1]){
					valueOflargestValidOne = validValues[0];
					indexOfLargestValidOne = validIndexes[0];
				} else {
					valueOflargestValidOne = validValues[1];
					indexOfLargestValidOne = validIndexes[1];
				}
				System.out.println("Row: " + loop + " index " + indexOfLargestValidOne + ": value: " + valueOflargestValidOne);
			}
			totalLikes = totalLikes + valueOflargestValidOne; 
			loop++;
		}
		treeScanner.close();
		System.out.println("Total: " + totalLikes);
	}
}
