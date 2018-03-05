package Solution;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2018/3/5.
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.

 “这 道题属于纯粹的字符串操作，要把一串单词安排成多行限定长度的字符串。
 主要难点在于空格的安排，首先每个单词之间必须有空格隔开，而当当前行放不下更多的
 单词并且字符又不能填满长度L时，我们要把空格均匀的填充在单词之间。
 如果剩余的空格量刚好是间隔倍数那么就均匀分配即可，否则还必须把多的一个空格放到 前面的间隔里面。
 实现中我们维护一个count计数记录当前长度，超过之后我们计算共同的空格量以及多出一个的空格量，
 然后将当行字符串构造出来。最后一 个细节就是最后一行不需要均匀分配空格，句尾留空就可以，
 所以要单独处理一下。时间上我们需要扫描单词一遍，然后在找到行尾的时候在扫描一遍当前行的单 词，
 不过总体每个单词不会被访问超过两遍，所以总体时间复杂度是O(n)。而空间复杂度则是结果的大小（
 跟单词数量和长度有关，不能准确定义，如果知道最 后行数r，则是O(r*L)）。
 */
public class Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        if (words==null||words.length==0) return res;
        int count = 0;
        int last = 0;
        for (int i = 0; i < words.length; i++) {
            if (count+words[i].length()+i-last>maxWidth){
                int spaceNum = 0;
                int extraNum = 0;
                if (i-last-1>0){
                    spaceNum=(maxWidth-count)/(i-last-1);
                    extraNum=(maxWidth-count)%(i-last-1);
                }
                StringBuilder str = new StringBuilder();
                for (int j = last; j < i; j++) {
                    str.append(words[j]);
                    if (j<i-1){
                        for (int k = 0; k < spaceNum; k++) {
                            str.append(" ");
                        }
                        if (extraNum>0){
                            str.append(" ");
                        }
                        extraNum--;
                    }
                }
                for (int j = str.length(); j < maxWidth; j++) {
                    str.append(" ");
                }
                res.add(str.toString());
                count=0;
                last=i;
            }
            count+=words[i].length();
        }
        //最后一行
        StringBuilder str = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            str.append(words[i]);
            if (str.length()<maxWidth){
                str.append(" ");
            }
        }
        for (int i = str.length(); i < maxWidth; i++) {
            str.append(" ");
        }
        res.add(str.toString());
        return res;
    }
}


