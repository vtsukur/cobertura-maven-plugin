package org.codehaus.mojo.cobertura.util;

import net.sourceforge.cobertura.util.RegexUtil;

import java.util.HashSet;
import java.util.List;

/**
 * @author Vladimir Tsukur
 */
public class DependenciesMatchingUtil {

    public static boolean matchListRegex(List listStringPattern, String toMatch)
    {
        if (listStringPattern == null || listStringPattern.size() == 0)
        {
            return false;
        }
        final HashSet setPattern = new HashSet();
        for (Object regexp : listStringPattern)
        {
            RegexUtil.addRegex(setPattern, (String) regexp);
        }
        return RegexUtil.matches(setPattern, toMatch);
    }

}
