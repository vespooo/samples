package samples.cleancode.lawofdemeter.badsample;

public class Main {

    public static void main(){
        Address address = new Address();
        for(Sight sight :address.getCity().getSights()){
            System.out.println("sight: "+ sight.getName() + "location: " + sight.getLocation());
        }

    }

}
