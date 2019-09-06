package OA;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
public class Invoice {
    Map<String, Record> invoices = new HashMap<>();
    int owned = 0;
    public int getAmount(String invoice) {
        if (invoice.startsWith("CREATE") || invoice.startsWith("FINALIZE")) {
            String [] parts = invoice.split(": ");
            String[] content = parts[1].split("\\&");
            String id = content[0].split("=")[1];
            Integer amount = Integer.parseInt(content[1].split("=")[1]);
            String currency = content[2].split("=")[1];

            if (invoice.startsWith("CREATE")) {
                if (!invoices.containsKey(id) && currency.equals("USD")) {
                    invoices.put(id, new Record(id, amount, false));
                    owned += amount;
                }
            } else {
                if (invoices.containsKey(id) && !invoices.get(id).isFinalized &&
                        !invoices.get(id).isPaid && currency.equals("USD")) {
                    owned -= invoices.get(id).amount;
                    owned += amount;
                    invoices.get(id).amount = amount;
                    invoices.get(id).isFinalized = true;
                }
            }
        } else if (invoice.startsWith("PAY")) {
            String[] part = invoice.split(": ");
            String id = part[1].split("=")[1];
            if (invoices.containsKey(id) && invoices.get(id).isFinalized) {
                owned -= invoices.get(id).amount;
                invoices.get(id).isPaid = true;
            }
        }
        return this.owned;
    }
    public class Record {
        String id;
        int amount;
        boolean isFinalized;
        boolean isPaid;
        public Record(String id, int amount, boolean isFinalized) {
            this.id = id;
            this.amount = amount;
            this.isFinalized = true;
        }
    }
    public static void main(String[] args) {
        String input1 = "CREATE: id=13&amount=800&currency=USD";
        String input2 = "CREATE: id=16&amount=800&currency=USD";
        String input3 = "CREATE: id=16&amount=800&currency=USD";
        String input4 = "CREATE: id=19&amount=800&currency=YD";
        String input5 = "FINALIZE: id=16&amount=600&currency=USD";
        String input6 = "CREATE: id=14&amount=800&currency=USD";
        String input7 = "FINALIZE: id=14&amount=400&currency=USD";
        String input8 = "PAY: id=14";
        String input9 = "CREATE: id=14&amount=900&currency=USD";
        List<String> list = new ArrayList<> ();
        list.add(input1);
        list.add(input2);
        list.add(input3);
        list.add(input4);
        list.add(input5);
        list.add(input6);
        list.add(input7);
        list.add(input8);
        list.add(input9);
        Invoice iv = new Invoice();
        for (String str : list) {
            System.out.println(iv.getAmount(str));
        }
    }
}
