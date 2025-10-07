
public class Maff {
    private NodeList num1;
    private NodeList num2;

    public Maff(NodeList num1, NodeList num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public NodeList add(){
        return _add(this.num1, this.num2, 0);
    }

    private NodeList _add(NodeList num1, NodeList num2, int carry){
        NodeList ans = new NodeList();
        if(num1.getLength() <=0){
            return num2;
        }
        else if (num2.getLength() <= 0){
            return num1;
        }
        NodeList bigger;
        NodeList smaller;
        if(num1.getLength()>num2.getLength()){
            bigger = num1;
            smaller = num2;
        } else {
            bigger = num2;
            smaller = num1;
        }
        smaller.resetCur();
        bigger.resetCur();
        while(smaller.getCur() != null){
            int small = smaller.getCur().getValue();
            int big = bigger.getCur().getValue();
            int adding = (smaller.getCur().getValue() + bigger.getCur().getValue() + carry);
            if(adding > 9){
                carry = 1;
                adding -= 10;
                ans.append(adding);
            }
            else{
                carry = 0;
                ans.append(adding);
            }
            smaller.incrementCur();
            bigger.incrementCur();
        }

        while(bigger.getCur() != null){
            if (carry == 1) {
                int add = bigger.getCur().getValue() + 1;
                if(add > 9){
                    carry = 1;
                    add -= 10;
                    ans.append(add);
                }
                else {
                    carry = 0;
                    ans.append(add);
                }
            }
            else{
                ans.append(bigger.getCur().getValue());
            }
            bigger.incrementCur();
        }
        if(carry == 1){
            ans.append(carry);
        }

        return ans.reverse();
    }

    public NodeList multiply(){
        return _multiply(this.num1, this.num2, 0);
    }

    public NodeList _multiply(NodeList num1, NodeList num2, int carry){
        NodeList ans = new NodeList();
        NodeList bigger;
        NodeList smaller;
        if(num1.getLength()>num2.getLength()){
            bigger = num1;
            smaller = num2;
        } else {
            bigger = num2;
            smaller = num1;
        }
        // to see how many times we have run loop
        int i = 0;
        while (smaller.getLength() !=0){
            NodeList tempAns = new NodeList();
            // need to reset bigger for each loop through smaller
            bigger.resetCur();

            // for loop to add 0 to start of answer
            for (int j = 0; j < i; j++){
                tempAns.append(0);
            }

            carry = 0;

            // while loop with multiply each individual in smaller with bigger
            while((bigger.getCur() != null)&&(smaller.getLength()!=0)){
                if(carry == 0){
                    int multiply = smaller.getVal() * bigger.getCur().getValue();
                    int remainder = multiply % 10;
                    carry = (multiply - remainder)/10;
                    tempAns.append(remainder);
                }
                else if (carry !=0){
                    int multiply = smaller.getVal() * bigger.getCur().getValue() + carry;
                    int remainder = multiply % 10;
                    carry = (multiply - remainder)/10;
                    tempAns.append(remainder);
                }
                bigger.incrementCur();
            }
            if(carry != 0){
                tempAns.append(carry);
                carry = 0;
            }
            if (i > 0) {
                ans = _add(tempAns.reverse(), ans, 0);
            }
            else if (i == 0){
                ans = tempAns.reverse();
            }
            smaller.remove();
            i ++;
        }
        return ans;
    }

}
