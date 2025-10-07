import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


// all of node, nodelist, all of math
public class allTestCases {

    @Test
    public void testRemoveEmptyStrings() {
        String[] input = { "apple", "", "banana", "", "cherry" };
        String[] result = FileProcessor.removeEmptyStrings(input);
        String[] expected = { "apple", "banana", "cherry" };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testOperateAdd() {
        NodeList num1 = FileProcessor.convert("12345");
        NodeList num2 = FileProcessor.convert("54321");
        String result = FileProcessor.operate("+", num1, num2);
        String expected = "66666";
        assertEquals(expected, result);
    }

    @Test
    public void testOperateMultiply() {
        NodeList num1 = FileProcessor.convert("123");
        NodeList num2 = FileProcessor.convert("456");
        String result = FileProcessor.operate("*", num1, num2);
        String expected = "56088";
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveZeros() {
        String input = "00012345";
        String result = FileProcessor.removeZeros(input);
        String expected = "12345";
        assertEquals(expected, result);
    }

//    @Test(expected = Exception.class){
//
//    }

//    @Test(expect = FileNotFoundException.class)
//    public void testProcessFileError(){
//        File nonExistingFile = new File("blabla.txt");
//
//        // when
//        FileProcessor.processFile("meow meow");
//    }

//    @Test(expected = FileNotFoundException.class)
//    public void testProcessFileWithNonexistentFile() throws FileNotFoundException {
//        try{
//            FileProcessor.processFile("nonexistent.txt");
//        }
//        catch (FileNotFoundException i) {
//            return;
//        }
//        catch (Exception e){
//
//        }
//        fail(" exception not thrown");
//    }

    @Test
    public void testConvert(){
        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        NodeList meow = new NodeList();
        meow = FileProcessor.convert("321");
        // using print to compare to bypass any issues with grabbing the address of object
        //meow.toString();
        assertEquals(meow.toString(), test.toString());
    }

    @Test
    public void nodeGetters(){
        Node test = new Node(1, null);
        assertEquals(test.getNext(), null);
        assertEquals(test.getValue(), 1);
    }


    @Test
    public void testGetNext() {
        NodeList list = new NodeList();
        list.append(7); // next
        list.append(1); // cur
        assertEquals(7, list.getNext().getValue());
    }

    @Test
    public void testAppend(){
        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        assertEquals(test.toString(), "123");
        assertEquals(test.getLength(), 3);
    }


    @Test
    public void testGetLength() {
        NodeList list = new NodeList();
        list.append(4);
        list.append(8);
        list.append(12);
        assertEquals(3, list.getLength());
    }

    @Test
    public void testRemove() {
        NodeList list = new NodeList();
        list.append(4);
        list.append(8);
        list.append(1);
        list.remove();
        assertEquals(list.toString(), "48");
    }

    @Test
    public void testReverse() {
        NodeList nodeList = new NodeList();
        assertEquals(nodeList.getVal(), null);
        nodeList.append(5);
        nodeList.append(3);
        NodeList reversed = nodeList.reverse();
        assertEquals(reversed.toString(), "35");
        nodeList.resetCur();
        assertEquals(nodeList.getVal(), 3);
        assertEquals(nodeList.getCur().getValue(), 3);
        nodeList.incrementCur();
        assertEquals(nodeList.getCur().getValue(), 5);
        nodeList.resetCur();
        assertEquals(nodeList.getCur().getValue(), 3);
        nodeList.incrementCur();
        nodeList.incrementCur();
        assertEquals(nodeList.getCur(), null);
        assertEquals(nodeList.incrementCur(), null);
    }

    @Test
    public void testAdd01() {
        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        assertEquals(test.toString(), "123");
        NodeList num = new NodeList();
        num.append(1);
        NodeList done = new NodeList();
        Maff run = new Maff(test, num);
        done = run.add();
        assertEquals(done.toString(), "124");
    }

    @Test
    public void testAdd02() {
        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        assertEquals(test.toString(), "123");
        NodeList num = new NodeList();
        num.append(9);
        NodeList done = new NodeList();
        Maff run = new Maff(test, num);
        done = run.add();
        assertEquals(done.toString(), "132");
    }
    @Test
    public void testAddZero() {
        NodeList test = new NodeList();
        test.append(1);
        test.append(0);
        assertEquals(test.toString(), "10");
        NodeList num = new NodeList();
        num.append(1);
        num.append(2);
        assertEquals(num.toString(), "12");
        NodeList done = new NodeList();
        Maff run = new Maff(test, num);
        done = run.add();
        assertEquals("22", done.toString());
    }
    @Test
    public void testAdd03() {
        NodeList test = new NodeList();
        test.append(9);
        test.append(9);
        test.append(9);
        assertEquals(test.toString(), "999");
        NodeList num = new NodeList();
        num.append(1);
        NodeList done = new NodeList();
        Maff run = new Maff(test, num);
        done = run.add();
        assertEquals(done.toString(), "1000");
    }

    @Test
    public void testAdd4() {
        NodeList three = new NodeList();
        three.append(3);
        NodeList seven = new NodeList();
        seven.append(7);
        // Test with two single-digit numbers
        Maff maff1 = new Maff(three, seven);
        NodeList result1 = maff1.add();
        assertEquals("10", result1.toString());

        // Test with empty lists
        NodeList empty = new NodeList();
        NodeList five = new NodeList();
        five.append(5);
        Maff maff4 = new Maff(empty, five);
        NodeList result4 = maff4.add();
        assertEquals("5", result4.toString());

        Maff maffy = new Maff(five, empty);
        NodeList resulty = maffy.add();
        assertEquals("5", resulty.toString());
    }

    @Test
    public void testAddEdgeCases() {
        // Test with large numbers
        NodeList test = new NodeList();
        test.append(9);
        test.append(9);
        test.append(9);
        test.append(9);
        test.append(9);
        test.append(9);
        NodeList num = new NodeList();
        num.append(1);
        Maff maff1 = new Maff(test, num);
        NodeList result1 = maff1.add();
        assertEquals("1000000", result1.toString());
        Maff maff2 = new Maff(num, test);
        NodeList result2 = maff2.add();

        // Test with zero
        NodeList zero = new NodeList();
        zero.append(0);
        NodeList five = new NodeList();
        five.append(5);
        Maff mafff = new Maff(zero, five);
        NodeList result22 = mafff.add();
        assertEquals("5", result22.toString());
    }

    @Test
    public void addBig(){
        NodeList uno = new NodeList();
        uno.append(1);
        uno.append(1);
        uno.append(1);
        uno.append(1);
        uno.append(0);
        uno.append(4);
        uno.append(0);
        // 1111040
        NodeList dos = new NodeList();
        dos.append(9);
        dos.append(8);
        dos.append(7);
        dos.append(6);
        dos.append(4);
        dos.append(9);
        dos.append(0);
        dos.append(0);
        // 98764900
        Maff big = new Maff(uno, dos);
        assertEquals(big.add().toString(), "99875940");
    }

    @Test
    public void testMultiplySimple() {
        NodeList three = new NodeList();
        three.append(3);
        NodeList seven = new NodeList();
        seven.append(7);
        // Test with two single-digit numbers
        Maff maff1 = new Maff(three, seven);
        NodeList result1 = maff1.multiply();
        assertEquals("21", result1.toString());
    }

    @Test
    public void testMultiply() {

        NodeList test = new NodeList();
        test.append(1);
        test.append(2);
        test.append(3);
        NodeList num = new NodeList();
        num.append(5);
        // Test with one number larger than the other
        Maff maff2 = new Maff(test, num);
        NodeList result2 = maff2.multiply();
        assertEquals("615", result2.toString());

        // Test with different carry values
        NodeList nines = new NodeList();
        nines.append(9);
        nines.append(9);
        nines.append(9);
        NodeList two = new NodeList();
        two.append(2);
        Maff maff3 = new Maff(nines, two);
        NodeList result3 = maff3.multiply();
        assertEquals("1998", result3.toString());
//
//        // Test with empty lists
//        Maff maff4 = new Maff(new NodeList(), new NodeList(5));
//        NodeList result4 = maff4.multiply();
//        assertEquals("0", result4.toString());
    }

    @Test
    public void testTwoMultiply(){
        // Test with different carry values
        NodeList ten = new NodeList();
        ten.append(1);
        ten.append(0);
        ten.append(0);
        NodeList twenty = new NodeList();
        twenty.append(2);
        twenty.append(0);
        twenty.append(0);
        Maff maff3 = new Maff(ten, twenty);
        NodeList result3 = maff3.multiply();
        assertEquals("20000", result3.toString());
    }

    @Test
    public void testMultiply5221(){
        NodeList fift = new NodeList();
        fift.append(5);
        fift.append(2);
        fift.append(1);
        NodeList twent = new NodeList();
        twent.append(2);
        twent.append(1);
        // 10941
    }
    // DO 52 *99 (doesn't work)
    @Test
    public void testMults(){
        NodeList fiftwo = new NodeList();
        fiftwo.append(5);
        fiftwo.append(2);
        NodeList ninin = new NodeList();
        ninin.append(9);
        ninin.append(9);
        Maff tzsn = new Maff(fiftwo, ninin);
        NodeList ans;
        ans = tzsn.multiply();
        assertEquals(ans.toString(), "5148");
    }
    @Test
    public void testMultiply21(){
        // two numbers and overflow works
        NodeList fift = new NodeList();
        fift.append(5);
        fift.append(2);
        fift.append(9);
        NodeList twent = new NodeList();
        twent.append(2);
        twent.append(1);
        twent.append(9);
        Maff ans1 = new Maff(fift, twent);
        NodeList wow = ans1.multiply();
        assertEquals(wow.toString(), "115851");
        // 115851
    }
    @Test
    public void testMultiplyEdgeCases() {
        // Test with large numbers
        NodeList test1 = new NodeList();
        test1.append(1);
        test1.append(2);
        test1.append(3);
        test1.append(4);
        test1.append(5);
        test1.append(6);
        NodeList test2 = new NodeList();
        test2.append(7);
        test2.append(8);
        test2.append(9);
        test2.append(0);
        Maff maff1 = new Maff(test1, test2);
        NodeList result1 = maff1.multiply();
        assertEquals("974067840", result1.toString());

        // Test with zero
        NodeList zero = new NodeList();
        zero.append(0);
        NodeList nines = new NodeList();
        nines.append(9);
        nines.append(9);
        nines.append(9);
        nines.append(9);
        Maff maff2 = new Maff(zero, nines);
        NodeList result2 = maff2.multiply();
        assertEquals("0", result2.toString());
    }

    @Test
    public void testMultiplyCarry(){
        NodeList niner = new NodeList();
        niner.append(9);
        niner.append(9);
        niner.append(9);
        niner.append(9);

        NodeList temp = new NodeList();
        temp.append(9);
        temp.append(9);
        temp.append(9);

        Maff meow = new Maff(niner, temp);
        NodeList mow = meow.multiply();
        assertEquals(mow.toString(), "9989001");
    }

}
