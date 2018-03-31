import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/answer")
public class runthefunction {

    public static void main( Set<String>[] args )
    {
        String filename="C:\\Users\\Boyi\\Desktop\\WordLadder_dictionary\\dictionary.txt";
        int answer =0;
        Set<String> wordList=0;
        File file= new File(filename);
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] chars = str.split("\\s+");//根据空格切割,获取每一个字符
            for (String eachChar : chars) {
                if (isEnglishCharacter(eachChar)) {//英文字符串
                    wordList.add(eachChar.toLowerCase());//改变成小写字母
                }
            }
        }
        scanner.close();//关闭流,节省资源
        fileReader.close();
        answer=Solution.ladderLength(args[0],args[1], wordList);


        System.out.println( answer );
    }
}
