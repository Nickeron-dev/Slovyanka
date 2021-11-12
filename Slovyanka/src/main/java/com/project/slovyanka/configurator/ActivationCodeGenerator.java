package com.project.slovyanka.configurator;

import java.util.Random;

/**
 * @author Illia Koshkin
 * Цей клас генерує коди активації. Він має константи, які налаштовують код.
 */
public class ActivationCodeGenerator {

    private static final int LENGTH_OF_CODE = 20;
    private static final int INDEX_OF_LAST_CAPITAL_ON_ASCII = 126;
    private static final int INDEX_OF_FIRST_CAPITAL_ON_ASCII = 97;
    private static final int INDEX_OF_LAST_LOWERCASE_LETTER_ON_ASCII = 90;
    private static final int INDEX_OF_FIRST_LOWERCASE_LETTER_ON_ASCII = 65;
    private static final int INDEX_OF_FIRST_NUMBER_ON_ASCII = 48;
    private static final int INDEX_OF_LAST_NUMBER_ON_ASCII = 57;
    private static final Random random = new Random();

    /**
     * Цей метод генерує код, для доступу до нього не треба створювати екземпляр класу,
     * бо функція - public static
     * @return код активації, згідно з налаштуваннями у константах. Тип String
     */
    public static String generate() {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < LENGTH_OF_CODE; i++) {
            int characterFirstBound = random.nextInt(INDEX_OF_LAST_LOWERCASE_LETTER_ON_ASCII - INDEX_OF_FIRST_LOWERCASE_LETTER_ON_ASCII) + INDEX_OF_FIRST_LOWERCASE_LETTER_ON_ASCII;
            int characterSecondBound = random.nextInt(INDEX_OF_LAST_CAPITAL_ON_ASCII - INDEX_OF_FIRST_CAPITAL_ON_ASCII) + INDEX_OF_FIRST_CAPITAL_ON_ASCII;
            int characterThirdBound = random.nextInt(INDEX_OF_LAST_NUMBER_ON_ASCII - INDEX_OF_FIRST_NUMBER_ON_ASCII) + INDEX_OF_FIRST_NUMBER_ON_ASCII;
            int choosingOneFromFirstAndSecondAndThird = random.nextInt(3);
            if(choosingOneFromFirstAndSecondAndThird == 0) {
                answer.append((char) characterFirstBound);
            } else if(choosingOneFromFirstAndSecondAndThird == 1) {
                answer.append((char) characterSecondBound);
            } else {
                answer.append((char) characterThirdBound);
            }
        }
        return answer.toString();
    }
}
