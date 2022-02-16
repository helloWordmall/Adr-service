package com.adr.service.impl;

import com.adr.entity.User;
import com.adr.repository.AdrCheckRepository;
import com.adr.service.AdrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.adr.utils.MathUtil.RandomMath;

@Service
public class AdrServiceImpl implements AdrService {

    @Resource
    public AdrCheckRepository adrCheckRepository;

    @Override
    public void selectRepeatData() {
        System.out.println("在运行了");
        int i=0;
        List<Map<String,Object>> repeatData=adrCheckRepository.selectRepeatOrigin();
        for(Map<String,Object> map:repeatData){
            System.out.println("第"+ ++i +"重复住院号");
            System.out.println(map.get("hospId"));
        }
    }

    @Override
    public void selectAdrRepeatData() {
        System.out.println("在运行了");
        int i=0;
        List<Map<String,Object>> repeatData=adrCheckRepository.selectAdrRepeatData();
        for(Map<String,Object> map:repeatData){
            System.out.println("第"+ ++i +"重复住院号:"+map.get("hospId")+" 出现"+map.get("times"));
        }
    }

    @Override
    public void selectAdrAge() {
        System.out.println("在运行了");
        int i=0;
        List<Map<String,Object>> repeatData=adrCheckRepository.selectAdrAge();
        for(Map<String,Object> map:repeatData){
            System.out.println(map.get("hospId") + "次数" + map.get("times"));
        }
    }

    @Override
    public void selectPartAge() {
        int num,four,five,six,seven,eight;
        num=four=five=six=seven=eight=0;
        int[] test = RandomMath(1,440,322);
        User user = new User();

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.setMaximumFractionDigits(3);

        for(int i=0;i<322;i++){
            user = adrCheckRepository.selectPartAge(test[i]);
            try{
                num = user.getAge();
            }catch(Exception e){
                System.out.println(i+"序列和具体值"+test[i]);
            }
            /*case只能写值*/
            if(num <= 40)
                four++;
            else if(num >40 && num <= 50)
                five++;
            else if(num >50 && num <= 60)
                six++;
            else if(num >60 && num <= 70)
                seven++;
            else if(num >70)
                eight++;
        }
        int zone = four + five + six + seven + eight;
        System.out.println("40岁以内有"+four+"人，占比"+df.format((double)four/zone));
        System.out.println("40到50岁以内有"+five+"人，占比"+df.format((double)five/zone));
        System.out.println("50到60岁以内有"+six+"人，占比"+df.format((double)six/zone));
        System.out.println("60到70岁以内有"+seven+"人，占比"+df.format((double)seven/zone));
        System.out.println("70岁以上有"+eight+"人，占比"+df.format((double)eight/zone));
        System.out.println("总共有"+zone+"人");
    }

    @Override
    public void start() {
        long hospId=adrCheckRepository.selectHospId(2);
        System.out.println(hospId);
    }
}
