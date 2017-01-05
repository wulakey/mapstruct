/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.test.bugs._849;

import java.io.Serializable;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.ap.testutil.IssueKey;
import org.mapstruct.ap.testutil.WithClasses;
import org.mapstruct.ap.testutil.runner.AnnotationProcessorTestRunner;

/**
 * @author Andreas Gudian
 *
 */
@WithClasses({ Source.class, Target.class, Issue849Mapper.class })
@RunWith(AnnotationProcessorTestRunner.class)
public class Issue849Test {

    @Test
    @IssueKey("849")
    public void shouldCompileWithAllImportsDeclared() {

        Source source = new Source();
        source.setSourceList( Arrays.asList( (Serializable) "test" ) );

        Target target = Issue849Mapper.INSTANCE.mapSourceToTarget( source );
        assertThat( target.getTargetList() ).containsExactly( "test" );

    }
}
