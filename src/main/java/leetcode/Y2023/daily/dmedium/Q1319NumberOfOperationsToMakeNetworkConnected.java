package leetcode.Y2023.daily.dmedium;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q1319NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet s= new DisjointSet(n);
        int connectedEdges=0;
        for (int [] edge:connections) {
            if(!s.union(edge[0],edge[1])) connectedEdges++;
        }
        int count=0;
        for(int i = 0; i<n; i++){
            if(s.find(i) == i) count++;
        }
        return connectedEdges>=(count-1)?(count-1):-1;
    }
    public class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for(int i = 0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }
         public int find(int x) {
             if(x==parent.get(x))return x;
             int xx=find(parent.get(x));
             parent.set(x,xx);
             return parent.get(x);
        }


        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX==rootY) return false;
            if(size.get(rootX) < size.get(rootY)){
                parent.set(rootX, rootY);
                size.set(rootY, size.get(rootY)+size.get(rootX));
                return true;
            }else{
                parent.set(rootY, rootX);
                size.set(rootX, size.get(rootY)+size.get(rootX));
                return true;
            }
        }
    }

    @Test
    public void testmakeConnected(){
        int[][] test=Ps.intArray("[[0,1],[0,2],[0,3],[1,2],[1,3]]");
        assertEquals(2,makeConnected(6,test) );
        test=Ps.intArray("[[0,1],[0,2],[0,3],[1,2]]");
        assertEquals(-1,makeConnected(6,test));
    }
}
