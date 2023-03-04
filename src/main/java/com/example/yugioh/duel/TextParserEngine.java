package com.example.yugioh.duel;

import com.example.yugioh.card.Card;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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

    public static String  analyseSimpleText(String text) throws UnsupportedEncodingException
    {
        // Regular expression to match effect types and their values
        Pattern pattern = Pattern.compile("(DESTROY_SPELL_TRAP|DESTROY_MONSTER|DESTROY_HAND|DESTROY_DECK|BANISH|SEND_GV|SEND_NHAND|SEND_NDECK|DRAW|SEARCH_DECK|CHANGE_POSITION|CHANGE_CONTROL|CHANGE_ATK_DEF|PIERCING|ATTACK_MULTIPLE|LIMIT_ATTACK|DIRECT_ATTACK|SPECIAL_SUMMON|TOKEN|TYPE_RELATED|ATTRIBUTE_RELATED|DAMAGE_LP|GAIN_LP|NEGATE_ATTACK|NEGATE_EFFECT|ACTIVATE|TARGET|RECOVER_FROM_GY|CANT_DESTROY|CANT_SUMMON|CANT_ATTACK|COUNTER)\\s*(\\([\\w\\s,]+\\))?");

        Matcher matcher = pattern.matcher(sentence);
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
    public static void addTagsTo(Card c) throws UnsupportedEncodingException {
        if (c.getTypes().contains("Effect"))
        {
            List<Effect> effects = new ArrayList<>();

            String desc = c.getDesc();

            String[] sentences = desc.split("\\.");

            for (String sentence : sentences)
            {
                Effect effect = analyseSentence(sentence);

                effects.add(effect);
            }

            c.setEffects(effects);
        }
    }
}
