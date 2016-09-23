import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.01.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
 
public class Main{
	
	class Graph {
		@SuppressWarnings("rawtypes")
		Vector[] vec = new Vector[20001];
		int link[] = new int[20001];
		
		
		Graph(int m){
			for(int i = 0 ; i < m+1; i++)
				vec[i] = new Vector();
		}
		
	
		
		void dfs(int node, int c){
			link[node] = c;
			for(int i = 0 ; i<vec[node].size();i++){
				int next= (int) vec[node].get(i);
				if(link[next] == 0)
					dfs(next,3-c);
				
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		int testNum = sc.nextInt();
		while(testNum >0){
			int n  = sc.nextInt();
			int m = sc.nextInt();
			
			Graph g = main.new Graph(n);
			for(int i = 1; i <= n; i++){
				g.link[i] = 0;
			}
			
			for(int i = 0 ; i < m ; i ++){
				int u = sc.nextInt();
				int v = sc.nextInt();
				g.vec[u].add(v);
				g.vec[v].add(u);
			}
			for(int i = 1; i <= n ; i++){
				Collections.sort(g.vec[i]);
			}
			
			for(int i = 1; i<=n;i++){
				if(g.link[i] == 0)
					g.dfs(i,1);
			}
			boolean isOk = true;
			
			for(int i = 1; i <= n; i++){
				
				for(int x = 0; x < g.vec[i].size(); x++  ){
					int j = (int) g.vec[i].get(x);
					if(g.link[i] == g.link[j]){
						isOk = false;
					}
				}
			}
			System.out.printf("%s\n",isOk?"YES":"NO");
			testNum--;
			
		}
	}

}
