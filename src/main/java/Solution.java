import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public ArrayList<ArrayList<Integer>> permute(ArrayList A) {
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        permute(ans,A,0);
        return ans;
    }

    public void permute(ArrayList<ArrayList<Integer>>ans,
                        ArrayList<Integer>A, int idx){
        if(idx>=A.size()){
            ans.add(new ArrayList<Integer>(A));
            return;
        }
        for(int i=idx;i<A.size();i++){
            Collections.swap(A,i,idx);
            permute(ans, A, idx+1);
            Collections.swap(A,i,idx);
        }
    }
}
