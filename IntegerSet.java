import java.util.ArrayList;

/**ADT ที่เก็บ Integer จำนวนเต็มใดๆ เรียงจากน้อยไปมาก และห้ามมี null หรือตัวเลขซ้ำ
 */

public class IntegerSet {
    ArrayList<Integer> Number; //Rep

    // Rep Invariant (RI):
    //  - Number must not be null or empty.
    //  - Number must not contain duplicate Integer.
    //  - Integer in Number must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF(Number) = the set of integer in the Array n.

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet() {
        Number = new ArrayList<>();
        checkRep();
    }

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep() {
        for (int i = 0; i < Number.size()-1 ; i++) {
            if (Number.get(i) >= Number.get(i+1)) {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
    
    }

    /**
     * เพิ่มตัวอักษรเข้าเซต
     * @param number ตัวเลขที่ต้องการเพิ่ม
     */
    public void add(Integer number) {
        if (!Number.contains(number)) {
            int i = 0 ;
            while (i < Number.size() && Number.get(i) < number) {
                i++;
            }
            Number.add(number);
        }
        checkRep();
    }

    /**
     * ลบตัวอักษรออกจากเซต
     * @param number ตัวเลขที่ต้องการลบ
     */
    public boolean remove(Integer number) {
        boolean removed = Number.remove(number);
        checkRep();
        return removed;
    }

    /**
     * ตรวจสอบว่ามีตัวเลขนี้อยู่ในเซตหรือไม่
     * @param number ตัวอักษรที่ต้องการตรวจสอบ
     * @return true หากมี number อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer number){
        return Number.contains(number);
    }

    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return Number.size();
    }

    public String toString() {
        if(Number.isEmpty())
            return "{}";

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < Number.size(); i++) {
            sb.append(Number.get(i));
            if (i < Number.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
