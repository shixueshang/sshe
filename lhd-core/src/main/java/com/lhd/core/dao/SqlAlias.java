package com.lhd.core.dao;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlAlias
{
    private static Pattern SQL;
    private static Pattern ALIAS = Pattern.compile(
            "(?:[a-zA-Z]\\w*\\.)*([a-zA-Z]\\w*(?:\\(.*?\\))?|\\*|'.*?'|(?:\\d+\\.)?\\d+)(?:\\s+(?:as\\s+)?\"?(\\w+)\"?)?|,|\\|\\||[\\+\\-\\*\\/]",
            2);

    static
    {
        String with = "(?:\\w+(?:\\s*\\(.*?\\)\\s*|\\s+)as\\s*\\(.*?(?:'.*?'|\\(.*?(?:'.*?')*.*?\\))*.*?\\))";

        String sql = "(?:with\\s+(?:$WITH\\s*,\\s*)*$WITH)?\\s*select(.*?)\\bfrom\\b".replaceAll("\\$WITH",
                Matcher.quoteReplacement(with));
        SQL = Pattern.compile(sql, 2);
    }

    public static String[] bySelect(String sql)
    {
        Matcher m = SQL.matcher(sql);
        if ((m.find()) && (m.group(1) != null)) {
            if (m.group(1) == null) {
                throw new IllegalArgumentException("No 'Select' Founded!!!");
            }
            LinkedList aliases = new LinkedList();
            m = ALIAS.matcher(m.group(1));

            boolean concatOpen = false;
            String concatExpr = "";
            while (m.find()) {
                boolean concatClose = true;
                String alias = m.group(2);
                String field = m.group(1);
                String _wholeFiled = m.group();
                if (m.find()) {
                    if ("+-*/||".contains(m.group())) {
                        concatOpen = true;
                        concatClose = false;
                    } else if (!",".equals(m.group())) {
                        throw new IllegalArgumentException("Bad Sql,expect [,] but [ " + m.group() + " ] was found !");
                    }
                }
                if (concatOpen) {
                    concatExpr = concatExpr + _wholeFiled;
                    if (concatClose) {
                        aliases.add(alias != null ? alias : concatExpr);
                        concatOpen = false;
                        concatExpr = "";
                    } else {
                        concatExpr = concatExpr + m.group();
                    }
                } else {
                    aliases.add(alias != null ? alias : field);
                }
            }
            return (String[])aliases.toArray(new String[aliases.size()]);
        }
        throw new IllegalArgumentException("Bad Sql!!!");
    }
}