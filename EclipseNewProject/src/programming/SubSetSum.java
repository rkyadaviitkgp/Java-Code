package programming;

public class SubSetSum {

	public static void printArray(int[] ans) {
		System.out.println();
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
	}

	public static int subSetSum(int size, int[] dynTable, int[] width, int[] height, int profit, int[] dynSelected,
			int ind) {

		if (size < 0)
			return -1;

		if (size == 0)
			return profit;

		if (ind == width.length)
			return -1;

		if (dynTable[size] != -1)
			return dynTable[size];

		int v1 = subSetSum(size - width[ind], dynTable, width, height, profit + width[ind] * height[ind], dynSelected,
				ind + 1);
		int v2 = subSetSum(size - height[ind], dynTable, width, height, profit + width[ind] * height[ind], dynSelected,
				ind + 1);
		int v3 = subSetSum(size, dynTable, width, height, profit, dynSelected, ind + 1);

		int maxVal = -1;

		if (v1 > v2) {
			if (v1 > v3) {
				maxVal = v1;
				dynSelected[ind] = 1;
			} else {
				maxVal = v3;
				dynSelected[ind] = 3;
			}
		} else {
			if (v2 > v3) {
				maxVal = v2;
				dynSelected[ind] = 2;
			} else {
				maxVal = v3;
				dynSelected[ind] = 3;
			}
		}

		// System.out.println("for size " + size + " the max value is " + maxVal+" and
		// selected is " + selected);
		// dynSelected[size] = selected;
		dynTable[size] = maxVal;
		return maxVal;

	}

	// public static int subSetSum(int size, int[] dynTable, int[] width, int[]
	// height, int profit, int[] dynSelected) {
	//
	// if(size < 0)
	// return -1;
	//
	// if(size == 0)
	// return profit;
	//
	// if(dynTable[size] != -1)
	// return dynTable[size];
	//
	// int maxVal = -1;
	// int selected = 0;
	// for(int i=0; i<width.length; i++)
	// {
	// int sel = width[i];
	// int v1 = subSetSum(size-width[i], dynTable, width, height, profit + width[i]
	// * height[i], dynSelected );
	//
	// int v2 = subSetSum(size-height[i], dynTable, width, height, profit + width[i]
	// * height[i], dynSelected );
	// if(v2 > v1)
	// {
	// v1= v2;
	// sel = height[i];
	// }
	// if(maxVal < v1)
	// {
	// maxVal = v1;
	// selected = sel;
	// }
	// }
	// //System.out.println("for size " + size + " the max value is " + maxVal+" and
	// selected is " + selected);
	// dynSelected[size] = selected;
	// dynTable[size] = maxVal;
	// return maxVal;
	//
	// }

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int[] height = { 10, 21, 3, 4 };
		int[] width = { 10, 3, 3, 4 };
		int size = 10;
		int[] dynTable = new int[size + 1];
		for (int i = 0; i <= size; i++)
			dynTable[i] = -1;
		int[] dynSelected = new int[size + 1];
		subSetSum(size, dynTable, width, height, 0, dynSelected, 0);
		printArray(dynTable);
		printArray(dynSelected);
		// System.out.println(dynTable[size]);
	}

}
