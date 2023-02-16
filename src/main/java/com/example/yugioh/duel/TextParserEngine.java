package com.example.yugioh.duel;

import com.example.yugioh.card.Card;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



public class TextParserEngine {
    //private String[] conjunctives= {"then", "and", "and if you do", "also", "also, after"};

    public boolean isChainEffect(String cardType, String text)
    {
        if (cardType.contains("SPELL") || cardType.contains("TRAP")) {return true;}
        else if (text.contains(":") || text.contains(";")) {return true;}
        else {return false;}
    }

    public static String analyseResolution(String resolution)
    {
        return resolution;
    }

    public static Activation analyseActivation(String activation)
    {
        String activ = activation ;

        String condition = "";

        if (activation.contains(":"))
        {
            condition = activation.split(":")[0];
            activ = activation.split(":")[1];
        }

        Activation activationReturn = new Activation(activ, condition);

        return activationReturn;
    }

    public static String analyseCondition(String condition)
    {
        return condition;
    }

    public static void analyseSimpleText(String text) throws UnsupportedEncodingException
    {

        if (text.contains("\u25cf") == true)
        {
            System.out.println("textContainsDot");
        }
        else
        {
            System.out.println("No ';' or ':' in the sentence :  " + text);
        }
    }
    public static Effect analyseSentence(String sentence)
    {
        Effect effect = new Effect();

        if (sentence.contains(";"))
        {
            effect.setResolution(analyseResolution(sentence.split(";")[1]));
            effect.setActivation(analyseActivation(sentence.split(";")[0]));
        }
        else if (sentence.contains(":"))
        {
            effect.setActivation(analyseActivation(sentence));
        }
        else
        {
            try
            {
                analyseSimpleText(sentence);
            }
            catch (UnsupportedEncodingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return effect;
    }
    public static void addTagsTo(Card c)
    {
        if (c.getTypes().contains("Effect"))
        {
            List<Effect> effects = new ArrayList<>();

            String[] sentences = c.getDesc().split("\\.");

            for (String sentence : sentences)
            {
                Effect effect = analyseSentence(sentence);
                effects.add(effect);
            }
        }
    }
}
