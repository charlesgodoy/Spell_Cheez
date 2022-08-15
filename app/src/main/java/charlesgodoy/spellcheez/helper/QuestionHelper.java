package charlesgodoy.spellcheez.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import charlesgodoy.spellcheez.R;
import charlesgodoy.spellcheez.model.QuestionModel;

public class QuestionHelper {

    private static List<QuestionModel> generateQuestions() {
        List<QuestionModel> list = new ArrayList<>();

        list.add(new QuestionModel(R.drawable.artichoke, "Artiechoke", "Artichowk", "Artichoke", "Artiechok", "Artichoke"));
        list.add(new QuestionModel(R.drawable.bicycle, "Bycicle", "Bicycle", "Bycikle", "Bicykle", "Bicycle"));
        list.add(new QuestionModel(R.drawable.cheese, "Cheese", "Chess", "Chiz", "Chiese", "Cheese"));
        list.add(new QuestionModel(R.drawable.horse, "Hours", "Hoorse", "Hors", "Horse", "Horse"));
        list.add(new QuestionModel(R.drawable.microphone, "Microphone", "Mycrophone", "Microfown", "Mycrofown", "Microphone"));
        list.add(new QuestionModel(R.drawable.motorcycle, "Motorcykle", "Motorcicle", "Motorcycle", "Motorcikle", "Motorcycle"));
        list.add(new QuestionModel(R.drawable.saxophone, "Saksofone", "Saxophone", "Saxofone", "Saksophone", "Saxophone"));
        list.add(new QuestionModel(R.drawable.silhouette, "Silhouette", "Silhowet", "Cilhowet", "Cilhouette", "Silhouette"));
        list.add(new QuestionModel(R.drawable.stethoscope, "Stetoscope", "Stetouscope", "Stethoscope", "Stetoescope", "Stethoscope"));
        list.add(new QuestionModel(R.drawable.tambourine, "Tamborine", "Tambourine", "Tambourien", "Tambourin", "Tambourine"));
        list.add(new QuestionModel(R.drawable.wardrobe, "Wardrove", "Wardrobe", "Weardrove", "Weardrobe", "Wardrobe"));
        list.add(new QuestionModel(R.drawable.xylophone, "Cylophone", "Xylophone", "Sylophone", "Silophone", "Xylophone"));
        list.add(new QuestionModel(R.drawable.anvil, "Anvil", "Envil", "Anbil", "Anvile", "Anvil"));
        list.add(new QuestionModel(R.drawable.apartment, "Afartment", "Apartement", "Apartmente", "Apartment", "Apartment"));
        list.add(new QuestionModel(R.drawable.bungalow, "Bongalow", "Bonggalow", "Bungalow", "Bunggalow", "Bungalow"));
        list.add(new QuestionModel(R.drawable.cello, "Chello", "Ciello", "Chelo", "Cello", "Cello"));
        list.add(new QuestionModel(R.drawable.cinnamon, "Cinamone", "Cinamon", "Cinnamon", "Cinnamone", "Cinnamon"));
        list.add(new QuestionModel(R.drawable.circuitry, "Circitry", "Circuitree", "Circuitry", "Circithree", "Circuitry"));
        list.add(new QuestionModel(R.drawable.elephant, "Elefant", "Elefunt", "Elephunt", "Elephant", "Elephant"));
        list.add(new QuestionModel(R.drawable.hamburger, "Hamburger", "Hamborger", "Hambourger", "Hamburgher", "Hamburger"));
        list.add(new QuestionModel(R.drawable.keyboard, "Kiebord", "Keybord", "Kieboard", "Keyboard", "Keyboard"));
        list.add(new QuestionModel(R.drawable.knight, "Night", "Knight", "Nite", "Nyt", "Knight"));
        list.add(new QuestionModel(R.drawable.lion, "Lyon", "Lieon", "Liyon", "Lion", "Lion"));
        list.add(new QuestionModel(R.drawable.papaya, "Papaya", "Fafaya", "Phapaya", "Paphaya", "Papaya"));
        list.add(new QuestionModel(R.drawable.pizza, "Pissa", "Pitza", "Pizza", "Pitzza", "Pizza"));
        list.add(new QuestionModel(R.drawable.popcorn, "Pupcorn", "Pupkorn", "Popcorn", "Popkorn", "Popcorn"));
        list.add(new QuestionModel(R.drawable.raspberry, "Ruspberry", "Raspberry", "Ruspverry", "Raspverry", "Raspberry"));
        list.add(new QuestionModel(R.drawable.spaghetti, "Spaghetti", "Sphagetti", "Spagetti", "Sphageti", "Spaghetti"));
        list.add(new QuestionModel(R.drawable.sushi, "Shushi", "Sushi", "Sushe", "Sushie", "Sushi"));
        list.add(new QuestionModel(R.drawable.theater, "Teater", "Thieter", "Theatter", "Theater", "Theater"));
        list.add(new QuestionModel(R.drawable.tomato, "Tomayto", "Tomato", "Tomatoe", "Toemato", "Tomato"));
        list.add(new QuestionModel(R.drawable.zucchini, "Suchini", "Zukhini", "Zucchini", "Zuchini", "Zucchini"));

        return list;
    }

    public static List<QuestionModel> getQuestionsList() {
        List<QuestionModel> list = generateQuestions();
        Collections.shuffle(list);
        return list;
    }

//    Stetoscope
//            Stetouscope
//    Stethoscope
//            Stetoescope
//
//    Tamborine
//            Tambourine
//    Tambourien
//            Tambourin
//
//    Wardrove
//            Wardrobe
//    Weardrove
//            Weardrobe
//
//    Cylophone
//            Xylophone
//    Sylophone
//            Silophone
//
//    Anvil
//            Envil
//    Anbil
//            Anvile
//
//    Afartment
//            Apartement
//    Apartmente
//            Apartment
//
//    Bongalow
//            Bonggalow
//    Bungalow
//            Bunggalow
//
//    Chello
//            Ciello
//    Chelo
//            Cello
//
//    Cinamone
//            Cinamon
//    Cinnamon
//            Cinnamone

}
