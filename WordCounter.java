
package wordcounter;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class WordCounter extends JFrame 
{
    JTextArea textarea;
    JLabel resultlabel;

    public WordCounter() 
    {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        textarea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textarea);
        add(scrollPane, BorderLayout.CENTER);

        JButton countButton = new JButton("Check Words");
        countButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String inputText = textarea.getText();
                int totalWordCount = countWords(inputText);
                int uniqueWordCount = countUniqueWords(inputText);
                Map<String, Integer> wordFrequency = getWordFrequency(inputText);
                displayStatistics(totalWordCount, uniqueWordCount, wordFrequency);
            }
        });
        add(countButton, BorderLayout.SOUTH);

        resultlabel = new JLabel();
        add(resultlabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private int countWords(String text) 
    {
        String[] words = text.split("[\\p{Punct}\\s]+");
        int wordCount = 0;
        for (String word : words) 
        {
            if (!word.isEmpty()) 
            {
                wordCount++;
            }
        }
        return wordCount;
    }

    private int countUniqueWords(String text) 
    {
        String[] words = text.split("[\\p{Punct}\\s]+");
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) 
        {
            if (!word.isEmpty()) 
            {
                uniqueWords.add(word.toLowerCase());
            }
        }
        return uniqueWords.size();
    }

    private Map<String, Integer> getWordFrequency(String text) 
    {
        String[] words = text.split("[\\p{Punct}\\s]+");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) 
        {
            if (!word.isEmpty()) 
            {
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word, 0)+1);
            }
        }
        return wordFrequency;
    }

    private void displayStatistics(int totalWordCount, int uniqueWordCount, Map<String, Integer> wordFrequency) 
    {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Total word count : ").append(totalWordCount).append("<br>");
        statistics.append("Unique word count : ").append(uniqueWordCount).append("<br>");
        statistics.append("Word frequency : ").append("<br>");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) 
        {
            statistics.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
        }

        resultlabel.setText("<html>" + statistics.toString() + "</html>");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new WordCounter();
            }
        });
    }
}

