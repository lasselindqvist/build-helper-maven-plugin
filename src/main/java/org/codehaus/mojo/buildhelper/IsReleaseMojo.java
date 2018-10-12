package org.codehaus.mojo.buildhelper;

/*
 * The MIT License
 *
 * Copyright (c) 2004, The Codehaus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Determine if the current version is a release version, and place it under a configurable project property
 *
 * @since 3.1.0
 */
@Mojo( name = "is-release", defaultPhase = LifecyclePhase.INITIALIZE, threadSafe = true )
public class IsReleaseMojo
    extends AbstractDefinePropertyMojo
{

    /**
     * The name of the property in which to store if the current version is a relese version.
     */
    @Parameter( defaultValue = "is.release" )
    private String isRelease;

    public void execute()
        throws MojoExecutionException
    {
    	boolean isRelease = false;
    	if (!getProject().getVersion().endsWith("SNAPSHOT")) {
    		isRelease = true;
    	}

        defineProperty( this.isRelease, Boolean.toString( isRelease ) );
        this.getLog().info( "Is release: " + this.getProject().getProperties().getProperty( Boolean.toString( isRelease ) ) );
    }
}
