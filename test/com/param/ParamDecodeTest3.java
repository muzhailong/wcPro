package com.param;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.param.ParamDecode.Options;

//分支覆盖
public class ParamDecodeTest3 {
	@Test
	public void testDecode1() {
		String[] args = null;
		Options op = null;
		ParamDecode pd = null;

		args = new String[] { "-x" };
		pd = new ParamDecode(args);
		op=pd.decode();
		assertEquals(op.isX,true);
	}
	
	@Test
	public void testDecode2() {
		String[] args = null;
		Options op = null;
		ParamDecode pd = null;

		args = new String[] { "1.txt" };
		pd = new ParamDecode(args);
		op=pd.decode();
		assertEquals(op.isConsole,true);
	}
	
	@Test
	public void testDecode3() {
		String[] args = null;
		Options op = null;
		ParamDecode pd = null;

		args = new String[] { "1*12" };
		pd = new ParamDecode(args);
		op=pd.decode();
		assertEquals(op.isErr,true);
	}

	@Test
	public void testDecode4() {
		String[] args = null;
		Options op = null;
		ParamDecode pd = null;
		args = new String[] { "1.txt" };
		pd = new ParamDecode(args);
		op=pd.decode();
		assertEquals(op.getFn(),"1.txt");
	}
}
