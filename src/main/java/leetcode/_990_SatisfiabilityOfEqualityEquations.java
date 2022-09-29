package leetcode;

public class _990_SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        _990_SatisfiabilityOfEqualityEquations obj = new _990_SatisfiabilityOfEqualityEquations();
        String[] equations = {"a==b","b==a"};

        System.out.println(obj.equationsPossible(equations));
    }

    public boolean equationsPossible(String[] equations) {
        //use union-find algorithm

        //step 0: initialize set, each variable has its own set
        int[] ids = new int[26]; // since variables are lowercase letters
        for (int i = 0; i < 26; i++) {
            ids[i] = i;
        }

        //step 1: for all equality equations put variables in same group
        for(String equation : equations) {
            if (equation.charAt(1) == '=') {
                int leftGrp = find(equation.charAt(0)-'a', ids);
                int rightGrp = find(equation.charAt(3)-'a', ids);

                if (leftGrp != rightGrp) {
                    ids[rightGrp] = leftGrp;
                }
            }
        }

        //step 2: for all inequality equations, check of variables are in same group
            // if yes, return false
        for(String equation : equations) {
            if (equation.charAt(1) == '!') {
                int leftGrp = find(equation.charAt(0)-'a', ids);
                int rightGrp = find(equation.charAt(3)-'a', ids);

                if (leftGrp == rightGrp) {
                    return false;
                }
            }
        }
        //step3: return true
        return true;
    }

    private int find(int var, int[] ids) {
        if(ids[var] == var) {
            return var;
        }

        return find(ids[var], ids);
    }

}
