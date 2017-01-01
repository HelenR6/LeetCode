import java.util.*;

public class Solution{
	public static void main(String[] args){
		int[][] arr = {
			{1,3,2},{2,4,3},{0,2,-2}
		};
		LC370_RangeAddition ra = new LC370_RangeAddition();
		int length = 5;
		int[] res = new int[length];
		res = ra.getModifiedArray(length, arr);
		for(int i : res){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/*
		Method to generate binary tree from String
		Format: "1 2 3 null 4 null 5"
				  1
			  2      3
		  null 4  null 5
	*/
	public static TreeNode generateTree(String str){
		if(str == null || str.length() == 0) return null;
		String[] words = str.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(words[0]));
		Queue<TreeNode> cur = new LinkedList<>();
		cur.add(root);
		int index = 1;
		TreeNode tmp = null;
		while(!cur.isEmpty()){
			Queue<TreeNode> next = new LinkedList<>();
			while(!cur.isEmpty()){
				tmp = cur.poll();
				if(index < words.length && !words[index].equals("null")){
					tmp.left = new TreeNode(Integer.parseInt(words[index]));
					next.add(tmp.left);
				}
				++index;
				if(index < words.length && !words[index].equals("null")){
					tmp.right = new TreeNode(Integer.parseInt(words[index]));
					next.add(tmp.right);
				}
				++index;				
			}
			cur = next;
		}
		return root;
	}
}