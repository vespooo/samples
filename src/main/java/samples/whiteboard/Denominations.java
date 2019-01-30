package samples.whiteboard;

import java.util.ArrayList;
import java.util.List;

public class Denominations {

    private List<List<Integer>> variants;

    public Denominations() {

        this.variants = new ArrayList<>();
    }

    public List<List<Integer>> findVariants(Integer amount, List<Integer> denominationList) {
        List<Integer> possibleVariants = new ArrayList<>();
        for (int i = 0; i < denominationList.size(); i++) {
            findVariants(amount, denominationList, possibleVariants, i);

        }
        System.out.println(variants);
        return variants;
    }

    private void findVariants(Integer amount, List<Integer> denominationList, List<Integer> possibleVariants, int pos) {

        int dnmnation = denominationList.get(pos);
        possibleVariants.add(dnmnation);
        int gap = amount - possibleVariants.stream().mapToInt(Integer::intValue).sum();
        if (gap >= 0) {
            if (gap == 0) {
                List<Integer> variant = new ArrayList<>();
                variant.addAll(possibleVariants);
                variants.add(variant);
                possibleVariants.clear();
                return;
            }

            if (denominationList.subList(pos, denominationList.size()).contains(gap)) {
                List<Integer> variant = new ArrayList<>();
                variant.addAll(possibleVariants);
                variant.add(gap);
                variants.add(variant);
            }

            findVariants(gap, denominationList, possibleVariants, pos);
        } else {
            possibleVariants.clear();
        }

    }
}



