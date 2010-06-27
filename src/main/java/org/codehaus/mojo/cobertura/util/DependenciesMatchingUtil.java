/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.codehaus.mojo.cobertura.util;

import net.sourceforge.cobertura.util.RegexUtil;

import java.util.HashSet;
import java.util.List;

/**
 * <p>Utility for matching a string against a list of regular expression patterns.</p>
 *
 * <p>Added as a part of refactoring effort.</p>
 *
 * @author Vladimir Tsukur
 */
public class DependenciesMatchingUtil {

    /**
     * Utility for matching a string against a list of regular expression patterns.
     *
     * @param listStringPattern list of regular expression patterns to use for matching.
     * @param toMatch string to match.
     *
     * @return <code>true</code> if given string matches at least one of the patterns in the list;
     * <code>false</code> otherwise.
     */
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
