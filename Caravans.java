import java.util.*;

public class Caravans {
	
	
//calculate distances working correct!!!	
	
public static void getDistances(int [] d, ArrayList<Integer> []arr,int r) {
	Queue <Integer> q=new LinkedList();
	q.add(r);
	
	boolean [] visited =new boolean [arr.length];
	visited[r-1]=true;
	d[r-1]=0;
	while(!q.isEmpty()) {
		int x=q.poll();
		
		for(int a:arr[x-1]) {
			if(visited[a]==false) {
				q.add(a+1);
				visited[a]=true;
				d[a]=d[x-1]+1;
			}
		}
		
		
	}
	
	
	
	
	
}

public static void BFSFromS(ArrayList<Integer> [] arr,int s,int f, int [] dfr) {
	Queue <Integer> q=new LinkedList();
	q.add(s);
	int [] d=new int [arr.length];
	int [] answers =new int [arr.length];
	boolean [] visited =new boolean [arr.length];
	visited[s-1]=true;
	d[s-1]=0;
	answers[s-1]=dfr[s-1];
	while(!q.isEmpty()) {
		int x=q.poll();
		
		for(int a:arr[x-1]) {
			if(visited[a]==false) {
				q.add(a+1);
				visited[a]=true;
				d[a]=d[x-1]+1;
				answers[a]=Math.min(answers[x-1],dfr[a]);
			}
			else if(d[a]==d[x-1]+1) {
				answers[a]=Math.max(answers[a],Math.min(answers[x-1],dfr[a]) );
			}
		}
	}
	
	
	System.out.println(answers[f-1]);
	
	
	
	
	
}
	
	
	
public static void main (String []args) {
	Scanner kb=new Scanner(System.in);
	int nvertices,nroads,va,vb,start,finish,robbers;
	nvertices=kb.nextInt();
	nroads=kb.nextInt();
	ArrayList<Integer> [] matrix=new ArrayList[nvertices];
	int [] distancesFromRobbers=new int [nvertices];
	
	for(int i=0;i<matrix.length;i++) {
		matrix[i]=new ArrayList<>();
	}
	
	
	//Filling array
	for(int i=0;i<nroads;i++) {
		va=kb.nextInt()-1;
		vb=kb.nextInt()-1;
		matrix[va].add(vb);
		matrix[vb].add(va);
	}
	
	//Filling the positions
	start=kb.nextInt();
	finish=kb.nextInt();
	robbers=kb.nextInt();
	

	
	getDistances(distancesFromRobbers,matrix,robbers);
	
	
	BFSFromS(matrix,start,finish,distancesFromRobbers);
	
	
}


}