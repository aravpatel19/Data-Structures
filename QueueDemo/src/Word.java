public class Word implements Comparable<Word>{

    private String word;

    public Word(String word){
        this.word = word.toLowerCase();
    }

    public String getWord(){
        return word;
    }

    public String toString() {
        return word;
    }

    public int compareTo(Word w) {

        //ascend
        return word.compareTo(w.toString());

        //descend
        //return w.getWord().compareToIgnoreCase(word);
    }
}
