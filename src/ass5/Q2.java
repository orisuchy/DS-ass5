package ass5;
import java.util.*;

public class Q2 {
	
	public static int[] inputArrAndSort(){
		
		//Scanner s = new Scanner(System.in);
		int[] arr1 = new int [inputArrSize()];
		for (int i=0; i<arr1.length;i++){
			arr1[i]=(int)(Math.random()*100)+1;
			
			/**System.out.println("type number:");
			arr1[i]=s.nextInt();**/	
		}
		System.out.println("your  array:");
		Print (arr1);
		System.out.println();
		Quicksort x =new Quicksort();
		x.sort(arr1);
		System.out.println("your array sorted:");
		Print (arr1);
		return arr1;
		
	}
	public static int findIndex(int[] sortedArr, int[] spinedArr, int numToFind){
		int index=0;
		int numOfSpins;
		System.out.println("-----------test----------");
		numOfSpins=findDfeka(spinedArr,0,spinedArr.length-1)+1;
		System.out.println();
		System.out.println("number of sipns is: "+numOfSpins);
		
		System.out.println("the index is: "+spinSearch(spinedArr,numOfSpins, numToFind));


		return index;
	}
	
	public static int spinSearch(int[] spinedArr, int numOfSpins, int numToFind){
		return spinSearch(spinedArr,0,spinedArr.length,numOfSpins,numToFind);
		
	}
	public static int spinSearch(int[] spinedArr, int first, int last, int numOfSpins, int numToFind){
		int index = -1;
		int supposedPivot = (int)((first+last)/2);
		int pivot = (supposedPivot+ numOfSpins)%spinedArr.length;
		if (spinedArr[pivot]==numToFind)
			index=pivot;
		else{
			if (spinedArr[pivot]<numToFind)
				index= spinSearch(spinedArr,first, (pivot-1+numOfSpins)%spinedArr.length, numOfSpins, numToFind);
			else
				index= spinSearch(spinedArr,(pivot+1+numOfSpins)%spinedArr.length, last, numOfSpins, numToFind);
		}
			
		return index;
		
	}
	
	//-----------------Methods----------------------
	public static int inputArrSize(){
		Scanner s = new Scanner(System.in);
		int size;
		System.out.println("type array size:");
		size = s.nextInt();
		return size;
	}

	public static void Print(int [] arr)
	{
		int j=0;
		for (int i=0; i<arr.length-1;i++)
		{
			System.out.print(arr[i]+",");
			j=i;
		}
		System.out.println(arr[j+1]);
	}
	public static int[] Spin (int[] arr){
		int spins = (int)(Math.random()*arr.length)+1;
		System.out.println();
		System.out.println("num of spins: "+spins);
		int [] arr2 = new int[arr.length];
			for (int i=0; i<arr2.length; i++)
				arr2[i]=arr[(arr.length+i-spins)%arr.length];
			System.out.println();
			System.out.println("your array after spin:");
			Print (arr2);
		return arr2;
	}
	public static int findDfeka(int[] arr, int first, int last){
		int output=-1;
		int index=(int)((first+last)/2);
		if (index>=arr.length | index<=0)
			return arr.length-1;
		else
		{
		if(arr[index]>arr[index+1])
			output=index;
		else {
			if (arr[index]<=arr[last])
			output=	findDfeka(arr,first,index-1);
			else if (arr[index]>=arr[first])
			output=	findDfeka(arr,index+1,last);
			
			return output;
		}
		return output;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArr = inputArrAndSort();
		int[] spinedArr = Spin(sortedArr);
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("find the index of: ");
		int toFind = s.nextInt();
		findIndex(sortedArr, spinedArr,toFind);
	}
	}
