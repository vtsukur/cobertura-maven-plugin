package org.codehaus.mojo.cobertura.module;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.codehaus.mojo.cobertura.util.DependenciesMatchingUtil.matchListRegex;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Anthonin Bonnefoy
 */
public class DependenciesModuleManagerTest
{
    final DependenciesModuleManager moduleManager = new DependenciesModuleManager();

    @Test
    public void testMatchListRegex() throws Exception
    {
        final List<String> stringList = Arrays.asList("com.group");
        assertThat(matchListRegex(stringList, "com.group"), Is.is(true));
    }

    @Test
    public void testMatchListRegexWithStar() throws Exception
    {
        final List<String> stringList = Arrays.asList("com.*");
        assertThat(matchListRegex(stringList, "com.group"), Is.is(true));
    }

    @Test
    public void anotherTestMatchListRegex() throws Exception
    {
        final List<String> stringList = Arrays.asList("test-multi-module");
        assertThat(matchListRegex(stringList, "test-multi-module"), Is.is(true));
    }

}
