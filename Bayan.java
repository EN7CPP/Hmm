import java.util.*;

public class Bayan {
	
	
//calculate distances working correct!!!	
	
public static void getDistances(int [] d, int [][] arr,int r) {
	Queue <Integer> q=new LinkedList();
	q.add(r);
	
	boolean [] visited =new boolean [arr.length];
	visited[r-1]=true;
	d[r-1]=0;
	while(!q.isEmpty()) {
		int x=q.poll();
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[x-1][i]==1&&visited[i]==false) {	
				q.add(i+1);
				d[i]=d[x-1]+1;
				visited[i]=true;
			}
		}
		
		
	}
	
	
	
	
	
}	
	
	
	
public static void main (String []args) {
	Scanner kb=new Scanner(System.in);
	int nvertices,nroads,va,vb,start,finish,robbers;
	nvertices=kb.nextInt();
	nroads=kb.nextInt();
	int [][] matrix=new int [nvertices][nvertices];
	int [] distancesFromRobbers=new int [nvertices];
	
	for(int [] r:matrix) {
		Arrays.fill(r,0);
	}
	
	
	//Filling array
	for(int i=0;i<nroads;i++) {
		va=kb.nextInt()-1;
		vb=kb.nextInt()-1;
		matrix[va][vb]=1;
		matrix[vb][va]=1;
	}
	
	//Filling the positions
	start=kb.nextInt();
	finish=kb.nextInt();
	robbers=kb.nextInt();
	
	for(int [] a:matrix) {
		for(int i:a) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	getDistances(distancesFromRobbers,matrix,robbers);
	
	for(int i:distancesFromRobbers) {
		System.out.println(i);
	}
	
	
	
	
}


}
