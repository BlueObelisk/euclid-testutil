/**
 *    Copyright 2011 Peter Murray-Rust, Nick England, David Jessop
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.xmlcml.euclid.test;

import org.junit.Assert;
import org.junit.Test;

public class TestDoubleTestBase {
	@Test
	public void testDoubleTestBase() {
		double[] test = new double[]{2.3,3.2,4.540001};
		double[] expected = new double[]{2.3,3.2,4.54};
		DoubleTestBase.assertEquals("Should be equal", expected, test, 0.001);
		DoubleTestBase.assertNotEquals("Should be not equal", expected, test, 0.0000000001);
	}
	@Test
	public void testAssertEqualsIfNull(){
		double[] expected = new double[]{2.3,3.2,4.54};
		double[] actual=null;
		DoubleTestBase.assertNotEquals("", expected, actual, 0.01);
		DoubleTestBase.assertNotEquals("", actual, expected, 0.01);
	}
	@Test
	public void testMatrix(){
		double[][] expected = new double[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				expected[i][j]=i+j;
			}
		}
		double[][] actual=new double[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				actual[i][j]=i+j+0.0001;
			}
		}
		Assert.assertNull(DoubleTestBase.testEquals(expected, actual, 0.01));
		Assert.assertNotNull(DoubleTestBase.testEquals(expected, actual, 0.000000001));
	}
}
