import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        elems =  new Pair[INITIAL_CAPACITY];
        count = 0;
        /* Your code here */
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null.");
        }
        Pair newItem = new Pair(key, value);
        int capacity = elems.length;
        if (count == capacity) {
            increaseCapacity();
        }

        elems[count] = newItem;
        count ++;
    }

    private void increaseCapacity() {
        int newInt = elems.length + INCREMENT;
        Pair[] temp = new Pair[newInt];

        for (int a = 0; a < elems.length; a ++ ) {
            temp[a] = elems[a];
        }


        elems = new Pair[elems.length + INCREMENT];

        elems = temp;
        /* Your code here.  Use this in put() where necessary. */
    }

    @Override
    public boolean contains(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        for (int a = count - 1; a >= 0; a --) {
            Pair element = elems[a];
            if (element.getKey().equals(key)) {
                if (element.getValue() != null) {
                    return true;
                }

            }
        }
        return false;
        /* Your code here. */
    }

    @Override
    public Integer get(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        

        Boolean marker = false;

        Integer val = 0;
        for (int a = count - 1; a >= 0; a --) {
            Pair element = elems[a];

            if ((!element.equals(null)) && (element.getKey().equals(key))) {
                val = element.getValue();
                marker = true;
                break;
            }
        }


        if (marker == false) {
            throw new NoSuchElementException();
        }
        return val;
        /* Your code here. */
    }

    @Override
    public void replace(String key, Integer value) {

        if (key == null || value == null) {
            throw new NullPointerException();
        }

        if (count == 0) {
            throw new NoSuchElementException();
        }

        Boolean marker = false;

        for (int a = count -1 ; a >= 0; a--) {
        
            if ((elems[a].getKey().equals(key))) {
                elems[a].setValue(value);
                marker = true;
                break;
            }
        }

        if (marker == false) {
            throw new NoSuchElementException();
        }
        /* Your code here. */
    }

    @Override
    public Integer remove(String key) {

        if (key == null) {
            throw new NullPointerException();
        }
        Integer value = 0;

        if (count == 0) {
            throw new NoSuchElementException();
        }
        Boolean marker = false;
        for ( int a = count - 1 ; a >= 0; a--) {
            if (elems[a].getKey().equals(key)) {
                value = elems[a].getValue();
                marker = true;
                for (int b = a; b < count - 1; b ++) {
                    elems[b] = elems[b + 1];
                }
                count --;
                break;
            }
        }

        if (marker == false) {
            throw new NoSuchElementException();
        }
        return value;

        /* Your code here. */
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}