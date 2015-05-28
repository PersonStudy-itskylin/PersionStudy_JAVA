package cn.hglq4.wzq.clazz;

import javax.swing.JPanel;

public class AI {
	int width = 19;
	private int x = 0, y = 0;
	private int temp1;
	private int temp2;
	private int temp3;
	private int temp4;
	public static AI ai = new AI();

	public static AI getInstance() {
		return ai;
	}

	// 计算机走棋
	/*
	 * 说明：用穷举法判断每一个坐标点的四个方向的的最大棋子数，最后得出棋子数最大值的坐标，下子
	 */
	void computerDo(int flag) {
		int max_black, max_white, count = 0, max = 0, max_temp, level, x[] = {
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2 }, y[] = { -2,
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
				-2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2 }, i, j;
		for (i = 0; i < width; i++) {
			for (j = 0; j < width; j++) {
				if (lian_si(i, j, 2) || duan_lian_si(i, j, 2)) {
					level = 43;
					x[level] = i;
					y[level] = j;
				} else {
					if (lian_si(i, j, 1) || duan_lian_si(i, j, 1)) {
						level = 42;
						x[level] = i;
						y[level] = j;
					} else {
						if (si_si(i, j, 2) && zhouwei3(i, j, 2)
								|| si_san(i, j, 2) && zhouwei3(i, j, 2)) {
							level = 41;
							x[level] = i;
							y[level] = j;
						} else {
							if (si_si(i, j, 2) && zhouwei2(i, j, 2)
									|| si_san(i, j, 2) && zhouwei2(i, j, 2)) {
								level = 40;
								x[level] = i;
								y[level] = j;
							} else {
								if (si_si(i, j, 2) && zhouwei1(i, j, 2)
										|| si_san(i, j, 2) && zhouwei1(i, j, 2)) {
									level = 39;
									x[level] = i;
									y[level] = j;
								} else {
									if (si_si(i, j, 2) || si_san(i, j, 2)) {
										level = 38;
										x[level] = i;
										y[level] = j;
									} else {
										if (huo_lian_san(i, j, 1)
												&& huo_lian_san(i, j, 2)) {
											level = 37;
											x[level] = i;
											y[level] = j;
										} else {
											if (huo_lian_san(i, j, 2)
													&& huo_duan_er(i, j, 2)
													|| huo_lian_san(i, j, 2)
													&& huo_er(i, j, 2)) {
												level = 36;
												x[level] = i;
												y[level] = j;
											} else {
												if (huo_lian_san(i, j, 2)
														&& zhouwei3(i, j, 2)
														|| duan_lian_san(i, j,
																2)
														&& zhouwei3(i, j, 2)) {
													level = 35;
													x[level] = i;
													y[level] = j;
												} else {
													if (huo_lian_san(i, j, 2)
															&& zhouwei2(i, j, 2)
															|| duan_lian_san(i,
																	j, 2)
															&& zhouwei2(i, j, 2)) {
														level = 34;
														x[level] = i;
														y[level] = j;
													} else {
														if (huo_lian_san(i, j,
																2)
																&& zhouwei1(i,
																		j, 2)
																|| duan_lian_san(
																		i, j, 2)
																&& zhouwei1(i,
																		j, 2)) {
															level = 33;
															x[level] = i;
															y[level] = j;
														} else {
															if (huo_lian_san(i,
																	j, 2)
																	|| duan_lian_san(
																			i,
																			j,
																			2)) {
																level = 32;
																x[level] = i;
																y[level] = j;
															} else {
																if (si_si(i, j,
																		1)
																		&& zhouwei3(
																				i,
																				j,
																				1)
																		|| si_san(
																				i,
																				j,
																				1)
																		&& zhouwei3(
																				i,
																				j,
																				1)) {
																	level = 31;
																	x[level] = i;
																	y[level] = j;
																} else {
																	if (si_si(
																			i,
																			j,
																			1)
																			&& zhouwei2(
																					i,
																					j,
																					1)
																			|| si_san(
																					i,
																					j,
																					1)
																			&& zhouwei2(
																					i,
																					j,
																					1)) {
																		level = 30;
																		x[level] = i;
																		y[level] = j;
																	} else {
																		if (si_si(
																				i,
																				j,
																				1)
																				&& zhouwei1(
																						i,
																						j,
																						1)
																				|| si_san(
																						i,
																						j,
																						1)
																				&& zhouwei1(
																						i,
																						j,
																						1)) {
																			level = 29;
																			x[level] = i;
																			y[level] = j;
																		} else {
																			if (si_si(
																					i,
																					j,
																					1)
																					|| si_san(
																							i,
																							j,
																							1)) {
																				level = 28;
																				x[level] = i;
																				y[level] = j;
																			} else {
																				if (huo_lian_san(
																						i,
																						j,
																						1)
																						&& huo_er(
																								i,
																								j,
																								2)
																						|| huo_lian_san(
																								i,
																								j,
																								1)
																						&& huo_duan_er(
																								i,
																								j,
																								2)) {
																					level = 27;
																					x[level] = i;
																					y[level] = j;
																				} else {
																					if (huo_lian_san(
																							i,
																							j,
																							1)
																							&& zhouwei3(
																									i,
																									j,
																									1)
																							|| duan_lian_san(
																									i,
																									j,
																									1)
																							&& zhouwei3(
																									i,
																									j,
																									1)) {
																						level = 26;
																						x[level] = i;
																						y[level] = j;
																					} else {
																						if (huo_lian_san(
																								i,
																								j,
																								1)
																								&& zhouwei2(
																										i,
																										j,
																										1)
																								|| duan_lian_san(
																										i,
																										j,
																										1)
																								&& zhouwei2(
																										i,
																										j,
																										1)) {
																							level = 25;
																							x[level] = i;
																							y[level] = j;
																						} else {
																							if (huo_lian_san(
																									i,
																									j,
																									1)
																									&& zhouwei1(
																											i,
																											j,
																											1)
																									|| duan_lian_san(
																											i,
																											j,
																											1)
																									&& zhouwei1(
																											i,
																											j,
																											1)) {
																								level = 24;
																								x[level] = i;
																								y[level] = j;
																							} else {
																								if (huo_lian_san(
																										i,
																										j,
																										1)
																										|| duan_lian_san(
																												i,
																												j,
																												1)) {
																									level = 23;
																									x[level] = i;
																									y[level] = j;
																								} else {
																									if (lian_duan_si(
																											i,
																											j,
																											2)
																											&& huo_er(
																													i,
																													j,
																													2)
																											|| lian_duan_si(
																													i,
																													j,
																													2)
																											&& huo_lian_san(
																													i,
																													j,
																													2)
																											|| lian_duan_si(
																													i,
																													j,
																													2)
																											&& huo_duan_er(
																													i,
																													j,
																													2)
																											|| si_lian_san(
																													i,
																													j,
																													2)
																											&& huo_er(
																													i,
																													j,
																													2)
																											|| si_lian_san(
																													i,
																													j,
																													2)
																											&& huo_lian_san(
																													i,
																													j,
																													2)
																											|| si_lian_san(
																													i,
																													j,
																													2)
																											&& huo_duan_er(
																													i,
																													j,
																													2)) {
																										level = 22;
																										x[level] = i;
																										y[level] = j;
																									} else {
																										if (san_san(
																												i,
																												j,
																												2)) {
																											level = 21;
																											x[level] = i;
																											y[level] = j;
																										} else {
																											if ((huo_er(
																													i,
																													j,
																													2) && san_san(
																													i,
																													j,
																													1))
																													|| (huo_duan_er(
																															i,
																															j,
																															2) && san_san(
																															i,
																															j,
																															1))) {
																												level = 20;
																												x[level] = i;
																												y[level] = j;
																											} else {
																												if (san_san(
																														i,
																														j,
																														1)) {
																													level = 19;
																													x[level] = i;
																													y[level] = j;
																												} else {
																													if (lian_duan_si(
																															i,
																															j,
																															1)
																															&& huo_er(
																																	i,
																																	j,
																																	1)
																															|| lian_duan_si(
																																	i,
																																	j,
																																	1)
																															&& huo_lian_san(
																																	i,
																																	j,
																																	1)
																															|| lian_duan_si(
																																	i,
																																	j,
																																	1)
																															&& huo_duan_er(
																																	i,
																																	j,
																																	1)
																															|| si_lian_san(
																																	i,
																																	j,
																																	1)
																															&& huo_er(
																																	i,
																																	j,
																																	1)
																															|| si_lian_san(
																																	i,
																																	j,
																																	1)
																															&& huo_lian_san(
																																	i,
																																	j,
																																	1)
																															|| si_lian_san(
																																	i,
																																	j,
																																	1)
																															&& huo_duan_er(
																																	i,
																																	j,
																																	1)) {
																														level = 18;
																														x[level] = i;
																														y[level] = j;
																													} else {
																														if (si_lian_san(
																																i,
																																j,
																																2)
																																|| lian_duan_si(
																																		i,
																																		j,
																																		2)) {
																															level = 17;
																															x[level] = i;
																															y[level] = j;
																														} else {
																															if (huo_er(
																																	i,
																																	j,
																																	2)
																																	&& shi_zi_er(
																																			i,
																																			j,
																																			2)) {
																																level = 16;
																																x[level] = i;
																																y[level] = j;
																															} else {
																																if ((huo_er(
																																		i,
																																		j,
																																		2) && huo_er(
																																		i,
																																		j,
																																		1))
																																		|| (huo_duan_er(
																																				i,
																																				j,
																																				2) && huo_er(
																																				i,
																																				j,
																																				1))
																																		|| (huo_duan_er(
																																				i,
																																				j,
																																				2) && huo_duan_er(
																																				i,
																																				j,
																																				1))
																																		|| (huo_er(
																																				i,
																																				j,
																																				2) && huo_duan_er(
																																				i,
																																				j,
																																				1))) {
																																	level = 15;
																																	x[level] = i;
																																	y[level] = j;
																																} else {
																																	if ((huo_er(
																																			i,
																																			j,
																																			2) && si_er(
																																			i,
																																			j,
																																			2))
																																			|| (huo_er(
																																					i,
																																					j,
																																					2) && si_er(
																																					i,
																																					j,
																																					1))) {
																																		level = 14;
																																		x[level] = i;
																																		y[level] = j;
																																	} else {
																																		if (huo_er(
																																				i,
																																				j,
																																				2)
																																				|| huo_duan_er(
																																						i,
																																						j,
																																						2)) {
																																			level = 13;
																																			x[level] = i;
																																			y[level] = j;
																																		} else {
																																			if (huo_er(
																																					i,
																																					j,
																																					2)
																																					&& zhouwei3(
																																							i,
																																							j,
																																							2)
																																					|| huo_duan_er(
																																							i,
																																							j,
																																							2)
																																					&& zhouwei3(
																																							i,
																																							j,
																																							2)) {
																																				level = 12;
																																				x[level] = i;
																																				y[level] = j;
																																			} else {
																																				if (huo_er(
																																						i,
																																						j,
																																						2)
																																						&& zhouwei2(
																																								i,
																																								j,
																																								2)
																																						|| huo_duan_er(
																																								i,
																																								j,
																																								2)
																																						&& zhouwei2(
																																								i,
																																								j,
																																								2)) {
																																					level = 11;
																																					x[level] = i;
																																					y[level] = j;
																																				} else {
																																					if (huo_er(
																																							i,
																																							j,
																																							2)
																																							&& zhouwei1(
																																									i,
																																									j,
																																									2)
																																							|| huo_duan_er(
																																									i,
																																									j,
																																									2)
																																							&& zhouwei1(
																																									i,
																																									j,
																																									2)) {
																																						level = 10;
																																						x[level] = i;
																																						y[level] = j;
																																					} else {
																																						if (huo_er(
																																								i,
																																								j,
																																								1)
																																								&& shi_zi_er(
																																										i,
																																										j,
																																										1)) {
																																							level = 9;
																																							x[level] = i;
																																							y[level] = j;
																																						} else {
																																							if (huo_er(
																																									i,
																																									j,
																																									1)
																																									&& zhouwei3(
																																											i,
																																											j,
																																											1)
																																									|| huo_duan_er(
																																											i,
																																											j,
																																											1)
																																									&& zhouwei3(
																																											i,
																																											j,
																																											1)) {
																																								level = 8;
																																								x[level] = i;
																																								y[level] = j;
																																							} else {
																																								if (huo_er(
																																										i,
																																										j,
																																										1)
																																										&& zhouwei2(
																																												i,
																																												j,
																																												1)
																																										|| huo_duan_er(
																																												i,
																																												j,
																																												1)
																																										&& zhouwei2(
																																												i,
																																												j,
																																												1)) {
																																									level = 7;
																																									x[level] = i;
																																									y[level] = j;
																																								} else {
																																									if (huo_er(
																																											i,
																																											j,
																																											1)
																																											&& zhouwei1(
																																													i,
																																													j,
																																													1)
																																											|| huo_duan_er(
																																													i,
																																													j,
																																													1)
																																											&& zhouwei1(
																																													i,
																																													j,
																																													1)) {
																																										level = 6;
																																										x[level] = i;
																																										y[level] = j;
																																									} else {
																																										if (huo_er(
																																												i,
																																												j,
																																												1)
																																												|| huo_duan_er(
																																														i,
																																														j,
																																														1)) {
																																											level = 5;
																																											x[level] = i;
																																											y[level] = j;
																																										} else {
																																											if (xie_zi_er(
																																													i,
																																													j,
																																													2)
																																													|| shi_zi_er(
																																															i,
																																															j,
																																															2)) {
																																												level = 4;
																																												x[level] = i;
																																												y[level] = j;
																																											} else {
																																												if (xie_zi_er(
																																														i,
																																														j,
																																														1)
																																														|| shi_zi_er(
																																																i,
																																																j,
																																																1)) {
																																													level = 3;
																																													x[level] = i;
																																													y[level] = j;
																																												} else {
																																													if (si_er(
																																															i,
																																															j,
																																															2)) {
																																														level = 2;
																																														x[level] = i;
																																														y[level] = j;
																																													} else {
																																														max_white = checkMax(
																																																i,
																																																j,
																																																2);// 判断白子的最大值
																																														max_black = checkMax(
																																																i,
																																																j,
																																																1);// 判断黑子的最大值
																																														if (max_white > max_black)
																																															max_temp = max_white;
																																														else
																																															max_temp = max_black;
																																														if (max_temp > max
																																																&& count == 0) {
																																															max = max_temp;
																																															count++;
																																															level = 1;
																																															x[level] = i;
																																															y[level] = j;
																																														} else if (count == 1) {
																																															for (int m = 0; m < width - 1; m++)
																																																for (int n = 0; n < width - 1; n++)
																																																	if (GameAction.ChessBox[m][n] == 2) {
																																																		level = 1;
																																																		if (m < this.width - 1
																																																				&& m >= 1
																																																				&& n >= 1
																																																				&& n < this.width - 1) {
																																																			if (GameAction.ChessBox[m + 1][n - 1] == 0) {
																																																				x[level] = m + 1;
																																																				y[level] = n - 1;
																																																			} else if (GameAction.ChessBox[m - 1][n + 1] == 0) {
																																																				x[level] = m - 1;
																																																				y[level] = n + 1;
																																																			}
																																																		}
																																																	}
																																															count = 0;
																																														}
																																													}
																																												}
																																											}
																																										}
																																									}
																																								}
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

			}
		}
		if (flag == 4) {
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					temp4 = i;
					break;
				}
			}
		}
		if (flag == 3) {
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					GameAction.ChessBox[x[i]][y[i]] = 1;
					computerDo(flag + 1);
					GameAction.ChessBox[x[i]][y[i]] = 0;
					temp3 = i;
					break;
				}
			}
		}
		if (flag == 2) {
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					GameAction.ChessBox[x[i]][y[i]] = 2;
					computerDo(flag + 1);
					GameAction.ChessBox[x[i]][y[i]] = 0;
					temp2 = i;
					break;
				}
			}
		} else if (flag == 1) {
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					GameAction.ChessBox[x[i]][y[i]] = 1;
					computerDo(flag + 1);
					GameAction.ChessBox[x[i]][y[i]] = 0;
					temp1 = i;
					break;
				}
			}
		} else if (flag == 0) {
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					GameAction.ChessBox[x[i]][y[i]] = 2;
					computerDo(flag + 1);
					GameAction.ChessBox[x[i]][y[i]] = 0;
					if (i >= 19
							&& (temp4 != 19 && temp4 != 20 && temp4 != 31
									&& temp4 != 23 && temp4 != 24
									&& temp4 != 25 && temp4 != 26
									&& temp4 != 27 && temp4 != 28
									&& temp4 != 29 && temp4 != 30 && temp4 != 42)
							|| temp4 >= 19) {
						this.x = x[i];
						this.y = y[i];
						GameAction.ChessBox[this.x][this.y] = 2;
						setX(this.x);
						setY(this.y);
						return;
					}
					if (i >= 19
							&& (temp3 != 20 && temp3 != 19 && temp3 != 31
									&& temp3 != 23 && temp3 != 24
									&& temp3 != 25 && temp3 != 26
									&& temp3 != 27 && temp3 != 28
									&& temp3 != 29 && temp3 != 30
									&& temp3 != 37 && temp3 != 42)
							|| (temp3 >= 19 && (temp3 != 20 && temp3 != 19
									&& temp3 != 31 && temp3 != 23
									&& temp3 != 24 && temp3 != 25
									&& temp3 != 26 && temp3 != 27
									&& temp3 != 28 && temp3 != 29
									&& temp3 != 30 && temp3 != 37 && temp3 != 42))) {
						this.x = x[i];
						this.y = y[i];
						GameAction.ChessBox[this.x][this.y] = 2;
						setX(this.x);
						setY(this.y);
						return;
					}
					if (i >= 19
							&& (temp2 != 20 && temp2 != 19 && temp2 != 31
									&& temp2 != 23 && temp2 != 24
									&& temp2 != 25 && temp2 != 26
									&& temp2 != 27 && temp2 != 28
									&& temp2 != 29 && temp2 != 30 && temp2 != 42)
							|| temp2 >= 19) {
						this.x = x[i];
						this.y = y[i];
						GameAction.ChessBox[this.x][this.y] = 2;
						setX(this.x);
						setY(this.y);
						return;
					}
					if (i >= 19
							&& (temp1 != 20 && temp1 != 19 && temp1 != 31
									&& temp1 != 23 && temp1 != 24
									&& temp1 != 25 && temp1 != 26
									&& temp1 != 27 && temp1 != 28
									&& temp1 != 29 && temp1 != 30
									&& temp1 != 37 && temp1 != 42)
							|| (temp1 >= 19 && (temp1 != 20 && temp1 != 19
									&& temp1 != 31 && temp1 != 23
									&& temp1 != 24 && temp1 != 25
									&& temp1 != 26 && temp1 != 27
									&& temp1 != 28 && temp1 != 29
									&& temp1 != 30 && temp1 != 37 && temp1 != 42))) {
						this.x = x[i];
						this.y = y[i];
						GameAction.ChessBox[this.x][this.y] = 2;
						setX(this.x);
						setY(this.y);
						return;
					}
				}
			}
			for (i = 43; i >= 1; i--) {
				if (x[i] != -2) {
					this.x = x[i];
					this.y = y[i];
					break;
				}
			}
			GameAction.ChessBox[this.x][this.y] = 2;
			setX(this.x);
			setY(this.y);
		}
	}

	public void first() {
		int height, width;
		// width = getWidth();
		// height = getHeight();
		// setX(width / 2);
		// setY(height / 2);
		// GameAction.ChessBox[width / 2][height / 2] = 2;
	}

	// 记录电脑下子后的横向坐标
	public void setX(int x) {
		this.x = x;
	}

	// 记录电脑下子后的纵向坐标
	public void setY(int y) {
		this.y = y;
	}

	// 获取电脑下子的横向坐标
	public int getX() {
		return this.x;
	}

	// 获取电脑下子的纵向坐标
	public int getY() {
		return this.y;
	}

	// 计算棋盘上某一方格上八个方向棋子的最大值，
	// 这八个方向分别是：左、右、上、下、左上、左下、右上、右下
	int checkMax(int x, int y, int black_or_white) {
		int num = 0, max_num, max_temp = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		// judge left
		x_temp1 = x_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (num < 5)
			max_temp = num;

		// judge up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 5; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		// judge down
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (num > max_temp && num < 5)
			max_temp = num;

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (num > max_temp && num < 5)
			max_temp = num;

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (num > max_temp && num < 5)
			max_temp = num;
		max_num = max_temp;
		return max_num;
	}

	// 判断 三三类型
	boolean san_san(int x, int y, int black_or_white) {
		int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0, flag6 = 0, flag7 = 0, flag8 = 0, flag9 = 0, flag10 = 0, flag11 = 0, flag12 = 0;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge up
		if (x_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 0)
				flag1 = 1;
		}
		if (x_temp1 >= 4 && x_temp1 <= width - 1)
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 0)
				flag1 = 1;
		// judge down
		x_temp1 = x_temp;
		if (x_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 0)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 0)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 0)
				flag2 = 1;
		}
		if (x_temp1 >= 1 && x_temp1 < width - 4)
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 0)
				flag2 = 1;
		if (x_temp1 >= 2 && x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0)
				flag9 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white)
				flag9 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0)
				flag9 = 1;
		}

		// judge left
		x_temp1 = x_temp;
		if (y_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 0)
				flag3 = 1;
		}
		if (y_temp1 >= 4 && y_temp1 < width - 1)
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 0)
				flag3 = 1;
		// judge right
		y_temp1 = y_temp;
		if (y_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 0)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 0)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 0)
				flag4 = 1;
		}
		if (y_temp1 >= 1 && y_temp1 < width - 4)
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 0)
				flag4 = 1;
		if (y_temp1 >= 2 && y_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0)
				flag10 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white)
				flag10 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0)
				flag10 = 1;
		}

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		if (y_temp1 >= 4 && x_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 0)
				flag5 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 >= 4 && y_temp1 < width - 1
				&& x_temp1 < width - 1)
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 0)
				flag5 = 1;
		// judge right_down
		if (y_temp1 < width - 4 && x_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 0)
				flag6 = 1;
		}
		if (y_temp1 >= 1 && x_temp1 >= 1 && y_temp1 < width - 4
				&& x_temp1 < width - 4)
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 0)
				flag6 = 1;
		if (y_temp1 >= 2 && y_temp1 < width - 2 && x_temp1 >= 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0)
				flag11 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white)
				flag11 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0)
				flag11 = 1;
		}

		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		if (y_temp1 >= 4 && x_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 0)
				flag7 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 >= 1 && y_temp1 < width - 1
				&& x_temp1 < width - 4)
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 0)
				flag7 = 1;
		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		if (y_temp1 < width - 4 && x_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 0)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 0)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 0)
				flag8 = 1;
		}
		if (y_temp1 >= 1 && x_temp1 >= 4 && y_temp1 < width - 4
				&& x_temp1 < width - 1)
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 0)
				flag8 = 1;
		if (y_temp1 >= 2 && y_temp1 < width - 2 && x_temp1 >= 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0)
				flag12 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white)
				flag12 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0)
				flag12 = 1;
		}
		if (flag1 + flag2 + flag3 + flag4 + flag5 + flag6 + flag7 + flag8
				+ flag9 + flag10 + flag11 + flag12 >= 2) {
			return true;
		}
		return false;
	}

	// 判断四三类型
	boolean si_san(int x, int y, int black_or_white) {
		int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0, flag6 = 0, flag7 = 0, flag8 = 0;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right_left_san
		if (x_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 0)
				flag1 = 1;
		}
		if (x_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 0)
				flag1 = 1;
		}
		if (x_temp1 >= 2 && x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white)
				flag1 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white)
				flag1 = 1;
		}
		// judge right_left_si
		if (x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 4 && x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 3 && x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 2 && x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 4 && x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 3 && x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 2 && x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}

		// judge up_down_san
		if (y_temp1 < width - 4 && y_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 0)
				flag3 = 1;
		}
		if (y_temp1 >= 4) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 0)
				flag3 = 1;

		}
		if (y_temp1 >= 2 && y_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white)
				flag3 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white)
				flag3 = 1;
		}
		// judge up_down_si
		if (y_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 5] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 5] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 4 && y_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 3 && y_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 2 && y_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 4 && y_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 3 && y_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 2 && y_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 3 - black_or_white)
				flag4 = 1;
		}

		// judge D_L_R_U_san
		if (y_temp1 < width - 4 && y_temp1 >= 1 && x_temp1 >= 4
				&& x_temp1 < width - 4) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 0
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 0)
				flag5 = 1;
		}
		if (y_temp1 >= 4 && y_temp1 < width - 1 && x_temp1 < width - 4
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 0
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 0)
				flag5 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 < width - 2 && y_temp1 < width - 2
				&& x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white)
				flag5 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white)
				flag5 = 1;
		}
		// judge D_L_R_U_si
		if (y_temp1 < width - 5 && x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 5] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 5] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 4 && x_temp1 >= 4 && y_temp1 >= 1
				&& x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 3 && x_temp1 >= 3 && y_temp1 >= 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 2 && x_temp1 >= 2 && y_temp1 >= 3
				&& x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 5 && x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 - 5] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 - 5] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 < width - 4 && y_temp1 < width - 1
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 3 && x_temp1 < width - 3 && y_temp1 < width - 2
				&& x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 < width - 2 && y_temp1 < width - 3
				&& x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 3 - black_or_white)
				flag6 = 1;
		}

		// judge L_U_R_D_san
		if (y_temp1 < width - 4 && y_temp1 >= 1 && x_temp1 < width - 4
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 0
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 0)
				flag7 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 >= 4 && y_temp1 < width - 1
				&& x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 0
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 0)
				flag7 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 >= 2 && y_temp1 < width - 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white)
				flag7 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white)
				flag7 = 1;
		}
		// judge L_U_R_D_si
		if (y_temp1 < width - 5 && x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 + 5] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 + 5] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 4 && x_temp1 < width - 4 && y_temp1 >= 1
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 3 && x_temp1 < width - 3 && y_temp1 >= 2
				&& x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 2 && x_temp1 < width - 2 && y_temp1 >= 3
				&& x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 5 && x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 >= 4 && y_temp1 < width - 1
				&& x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 3 && x_temp1 >= 3 && y_temp1 < width - 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 >= 2 && y_temp1 < width - 3
				&& x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 3 - black_or_white)
				flag8 = 1;
		}
		if (flag1 + flag3 + flag5 + flag7 >= 1
				&& flag2 + flag4 + flag6 + flag8 >= 1)
			return true;
		return false;
	}

	// 判断四四类型
	boolean si_si(int x, int y, int black_or_white) {
		int flag2 = 0, flag4 = 0, flag6 = 0, flag8 = 0;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right_left_si
		if (x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 4 && x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 3 && x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 < width - 2 && x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 4 && x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 3 && x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}
		if (x_temp1 >= 2 && x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1] == 3 - black_or_white)
				flag2 = 1;
		}

		// judge up_down_si
		if (y_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 5] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 5] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 4 && y_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 4] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 3 && y_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 < width - 2 && y_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 4 && y_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 4] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 3 && y_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 3] == 3 - black_or_white)
				flag4 = 1;
		}
		if (y_temp1 >= 2 && y_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 3 - black_or_white)
				flag4 = 1;
			else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1][y_temp1 - 2] == 3 - black_or_white)
				flag4 = 1;
		}

		// judge D_L_R_U_si
		if (y_temp1 < width - 5 && x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 5] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 5] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 4 && x_temp1 >= 4 && y_temp1 >= 1
				&& x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 + 4] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 3 && x_temp1 >= 3 && y_temp1 >= 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 < width - 2 && x_temp1 >= 2 && y_temp1 >= 3
				&& x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 5 && x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 - 1] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 - 1] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 < width - 4 && y_temp1 < width - 1
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 - 4] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 3 && x_temp1 < width - 3 && y_temp1 < width - 2
				&& x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 - 3] == 3 - black_or_white)
				flag6 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 < width - 2 && y_temp1 < width - 3
				&& x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 3 - black_or_white)
				flag6 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 - 2] == 3 - black_or_white)
				flag6 = 1;
		}

		// judge L_U_R_D_si
		if (y_temp1 < width - 5 && x_temp1 < width - 5) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 + 5] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 5][y_temp1 + 5] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 4 && x_temp1 < width - 4 && y_temp1 >= 1
				&& x_temp1 >= 1) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 4][y_temp1 + 4] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 3 && x_temp1 < width - 3 && y_temp1 >= 2
				&& x_temp1 >= 2) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 < width - 2 && x_temp1 < width - 2 && y_temp1 >= 3
				&& x_temp1 >= 3) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 5 && x_temp1 >= 5) {
			if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 4 && x_temp1 >= 4 && y_temp1 < width - 1
				&& x_temp1 < width - 1) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 0
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 4][y_temp1 - 4] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 3 && x_temp1 >= 3 && y_temp1 < width - 2
				&& x_temp1 < width - 2) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 3][y_temp1 - 3] == 3 - black_or_white)
				flag8 = 1;
		}
		if (y_temp1 >= 2 && x_temp1 >= 2 && y_temp1 < width - 3
				&& x_temp1 < width - 3) {
			if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == 0
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 3 - black_or_white)
				flag8 = 1;
			else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp1 + 2][y_temp1 + 2] == black_or_white
					&& GameAction.ChessBox[x_temp1 + 3][y_temp1 + 3] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == black_or_white
					&& GameAction.ChessBox[x_temp1 - 2][y_temp1 - 2] == 3 - black_or_white)
				flag8 = 1;
		}
		if (flag2 + flag4 + flag6 + flag8 >= 2)
			return true;
		return false;
	}

	// 判断死二类型
	boolean si_er(int x, int y, int black_or_white) {
		int num = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge left_up
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (x_temp1 < 0 || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || y_temp1 == width - 1 || x_temp == width - 2
				|| y_temp == 1)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 3 && y_temp >= 2
				&& y_temp1 <= width - 2)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp - 2] == 0)
				return true;
		// judge right_down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (x_temp1 >= width || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == width - 1 || y_temp1 == 0 || x_temp == 1
				|| y_temp == width - 2)
			return false;
		else if (x_temp >= 2 && x_temp1 <= width - 2 && y_temp1 >= 1
				&& y_temp <= width - 3)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp + 2] == 0)
				return true;
		// judge left_down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (x_temp1 < 0 || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || y_temp1 == 0 || x_temp == width - 2
				|| y_temp == width - 2)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 3 && y_temp1 >= 1
				&& y_temp <= width - 4)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp + 2] == 0)
				return true;
		// judge right_up
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (x_temp1 >= width || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == width - 1 || y_temp1 == width - 1 || x_temp == 1
				|| y_temp == 1)
			return false;
		else if (x_temp >= 2 && x_temp1 <= width - 2 && y_temp >= 2
				&& y_temp1 <= width - 2)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp - 2] == 0)
				return true;
		// judge right
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp == 1 || x_temp1 == width - 1)
			return false;
		else if (x_temp >= 2 && x_temp1 <= width - 2)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 + 1][y_temp1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp - 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp] == 0)
				return true;
		// judeg left
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || x_temp == width - 2)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 3)
			if (num == 2
					&& GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp + 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp] == 0)
				return true;
		// judge up
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (y_temp == 1 || y_temp1 == width - 1)
			return false;
		else if (y_temp >= 2 && y_temp1 <= width - 2)
			if (num == 2
					&& GameAction.ChessBox[x_temp1][y_temp1 + 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp - 2] == 0)
				return true;
		// judge down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (y_temp1 == 1 || y_temp == width - 1)
			return false;
		else if (y_temp1 >= 2 && y_temp <= width - 2)
			if (num == 2
					&& GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 2] == 0)
				return true;

		return false;
	}

	// 判断活二类型
	boolean huo_er(int x, int y, int black_or_white) {
		int num = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge left_up
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (x_temp1 < 0 || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || y_temp1 == width - 1 || x_temp1 == width - 1
				|| y_temp == 0)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 2 && y_temp >= 1
				&& y_temp1 <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0)
				return true;
		// judge right_down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (x_temp1 >= width || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == width - 1 || y_temp1 == 0 || x_temp == 0
				|| y_temp1 == width - 1)
			return false;
		else if (x_temp >= 1 && x_temp1 <= width - 2 && y_temp1 >= 1
				&& y_temp <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0)
				return true;
		// judge left_down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (x_temp1 < 0 || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || y_temp1 == 0 || x_temp1 == width - 1
				|| y_temp1 == width - 1)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 2 && y_temp1 >= 1
				&& y_temp <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0)
				return true;
		// judge right_up
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (x_temp1 >= width || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == width - 1 || y_temp1 == width - 1 || x_temp == 0
				|| y_temp == 0)
			return false;
		else if (x_temp >= 1 && x_temp1 <= width - 2 && y_temp >= 1
				&& y_temp1 <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0)
				return true;
		// judge right
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp == 0 || x_temp1 == width - 1)
			return false;
		else if (x_temp >= 1 && x_temp1 <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp - 1][y_temp] == 0)
				return true;
		// judeg left
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (x_temp1 == 0 || x_temp == width - 1)
			return false;
		else if (x_temp1 >= 1 && x_temp <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp] == 0)
				return true;
		// judge up
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (y_temp == 0 || y_temp1 == width - 1)
			return false;
		else if (y_temp >= 1 && y_temp1 <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp - 1] == 0)
				return true;
		// judge down
		num = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else
				break;
		}
		if (y_temp1 == 0 || y_temp == width - 1)
			return false;
		else if (y_temp1 >= 1 && y_temp <= width - 2)
			if (num == 2 && GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 1] == 0)
				return true;

		return false;
	}

	// 判断斜十字二类型
	boolean xie_zi_er(int x, int y, int black_or_white) {
		int num1 = 0, i, num2 = 0;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;

		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (x_temp1 >= width || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			x_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;

		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (x_temp1 < 0 || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			x_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;

		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (x_temp1 >= width || y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			x_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;

		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (x_temp1 < 0 || y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			x_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;
		return false;
	}

	// 判断十字二类型
	boolean shi_zi_er(int x, int y, int black_or_white) {
		int num1 = 0, i, num2 = 0;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;

		// judge right
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		// judeg down
		x_temp1 = x_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;
		// judge right
		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		// judge up
		x_temp1 = x_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;
		// judge left
		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		// judge down
		x_temp1 = x_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;
		// judge left
		num1 = 0;
		num2 = 0;
		x_temp = x;
		y_temp = y;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 3; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		// judge up
		x_temp1 = x_temp;
		for (i = 1; i < 3; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num1 == 1 && num2 == 1)
			return true;
		return false;
	}

	// 判断活断二类型
	boolean huo_duan_er(int x, int y, int black_or_white) {
		int x_temp, y_temp;
		x_temp = x;
		y_temp = y;
		// judge left_right
		if (x_temp >= 2 && x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp] == 0)
				return true;
		if (x_temp >= 2 && x_temp <= width - 4)
			if (GameAction.ChessBox[x_temp - 1][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp] == 0)
				return true;
		if (x_temp >= 3 && x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp] == 0)
				return true;
		// judge up_down
		if (y_temp >= 2 && y_temp <= width - 3)
			if (GameAction.ChessBox[x_temp][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 2] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 2] == 0)
				return true;
		if (y_temp >= 2 && y_temp <= width - 4)
			if (GameAction.ChessBox[x_temp][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 2] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 3] == 0)
				return true;
		if (y_temp >= 3 && y_temp <= width - 3)
			if (GameAction.ChessBox[x_temp][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 3] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 2] == 0)
				return true;

		// judge LU_RD
		if (y_temp >= 2 && y_temp <= width - 3 && x_temp >= 2
				&& x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp - 2] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp + 2] == 0)
				return true;
		if (y_temp >= 2 && y_temp <= width - 4 && x_temp >= 2
				&& x_temp <= width - 4)
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp - 2] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp + 3] == 0)
				return true;
		if (y_temp >= 3 && y_temp <= width - 3 && x_temp >= 3
				&& x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp - 3] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp + 2] == 0)
				return true;

		// judge LD_RU
		if (y_temp >= 2 && y_temp <= width - 3 && x_temp >= 2
				&& x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp + 2] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp - 2] == 0)
				return true;
		if (y_temp >= 2 && y_temp <= width - 4 && x_temp >= 2
				&& x_temp <= width - 4)
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == black_or_white
					&& GameAction.ChessBox[x_temp - 2][y_temp + 2] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp - 3] == 0)
				return true;
		if (y_temp >= 3 && y_temp <= width - 3 && x_temp >= 3
				&& x_temp <= width - 3)
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp + 3] == 0
					&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == black_or_white
					&& GameAction.ChessBox[x_temp + 2][y_temp - 2] == 0)
				return true;
		return false;
	}

	// 判断活连三类型
	boolean huo_lian_san(int x, int y, int black_or_white) {
		int num = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp1 < this.width - 1 && x_temp >= 1)
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 0
						&& GameAction.ChessBox[x_temp - 1][y_temp] == 0)
					return true;
		}
		// judge left
		x_temp1 = x_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp1 >= 1 && x_temp < this.width - 1)
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 0
						&& GameAction.ChessBox[x_temp + 1][y_temp] == 0)
					return true;
		}

		// judge up
		num = 0;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (y_temp1 >= 1 && y_temp < this.width - 1)
				if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 0
						&& GameAction.ChessBox[x_temp][y_temp + 1] == 0)
					return true;
		}
		// judge down
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (y_temp >= 1 && y_temp1 < this.width - 1)
				if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 0
						&& GameAction.ChessBox[x_temp][y_temp - 1] == 0)
					return true;
		}

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp1 >= 1 && y_temp1 >= 1 && x_temp < this.width - 1
					&& y_temp < this.width - 1)
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 0
						&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0)
					return true;
		}
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp >= 1 && y_temp >= 1 && x_temp1 < this.width - 1
					&& y_temp1 < this.width - 1)
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 0
						&& GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0)
					return true;
		}

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp >= 1 && y_temp1 >= 1 && x_temp1 < this.width - 1
					&& y_temp < this.width - 1)
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 0
						&& GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0)
					return true;
		}

		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (num == 3) {
			if (x_temp1 >= 1 && y_temp >= 1 && x_temp < this.width - 1
					&& y_temp1 < this.width - 1)
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 0
						&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0)
					return true;
		}
		return false;
	}

	// 判断连三类型
	boolean si_lian_san(int x, int y, int black_or_white) {
		int num = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp1 <= width - 2 && x_temp >= 1)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 + 1][y_temp1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}
		// judge left
		x_temp1 = x_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp1 >= 1 && x_temp <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 - 1][y_temp1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}

		// judge up
		num = 0;
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (y_temp1 >= 1 && y_temp <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp][y_temp + 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}
		// judge down
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (y_temp1 <= width - 2 && y_temp >= 1)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp][y_temp - 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp][y_temp - 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp1 >= 1 && y_temp1 >= 1 && y_temp <= width - 2
				&& x_temp <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp >= 1 && y_temp >= 1 && y_temp1 <= width - 2
				&& x_temp1 <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp - 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp >= 1 && y_temp1 >= 1 && y_temp <= width - 2
				&& x_temp1 <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp + 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 + 1][y_temp1 - 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}

		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num--;
			else
				break;
		}
		if (x_temp1 >= 1 && y_temp >= 1 && y_temp1 <= width - 2
				&& x_temp <= width - 2)
			if (num == 3) {
				if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 3 - black_or_white)
					return false;
				else if (GameAction.ChessBox[x_temp1 - 1][y_temp1 + 1] == 3 - black_or_white
						&& GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0) {
					if (black_or_white == 2)
						return true;
					else
						return false;
				} else
					return true;
			}
		return false;
	}

	boolean duan_lian_san(int x, int y, int black_or_white) {
		int num1 = 0, num2 = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width - 1)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp1 - x_temp != 3) {
				num1--;
				break;
			} else
				break;
		}

		x_temp1 = x_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			if (x_temp1 <= 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp - x_temp1 != 3) {
				num2--;
				break;
			} else
				break;
		}
		if (num1 != 3 && num2 != 3 && num1 + num2 > 2)
			return true;

		// judge up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 -= 1;
			if (y_temp1 <= 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& y_temp - y_temp1 != 3) {
				num1--;
				break;
			} else
				break;
		}
		// judge down
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width - 1)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& y_temp1 - y_temp != 3) {
				num2--;
				break;
			} else
				break;
		}
		if (num1 != 3 && num2 != 3 && num1 + num2 > 2)
			return true;

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 <= 0 || x_temp1 <= 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp - x_temp1 != 3) {
				num1--;
				break;
			} else
				break;
		}
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width - 1 || x_temp1 >= width - 1)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp1 - x_temp != 3) {
				num2--;
				break;
			} else
				break;
		}
		if (num1 != 3 && num2 != 3 && num1 + num2 > 2)
			return true;

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 <= 0 || x_temp1 >= width - 1)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp1 - x_temp != 3) {
				num1--;
				break;
			} else
				break;
		}
		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width - 1 || x_temp1 <= 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white
					&& x_temp - x_temp1 != 3) {
				num2--;
				break;
			} else
				break;
		}
		if (num1 != 3 && num2 != 3 && num1 + num2 > 2)
			return true;
		return false;
	}

	boolean lian_si(int x, int y, int black_or_white) {
		int num1 = 0, max_num, max_temp = 0, num2 = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		if (num1 == 4)
			return true;
		// judge left
		x_temp1 = x_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		max_temp = num1 + num2;

		// judge up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 5; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		if (num1 == 4)
			return true;
		// judge down
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num2 == 4)
			return true;
		if (num1 + num2 > max_temp)
			max_temp = num1 + num2;

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		if (num1 == 4)
			return true;
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num2 == 4)
			return true;
		if (num1 + num2 > max_temp)
			max_temp = num1 + num2;

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 5; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num1--;
			else
				break;
		}
		if (num1 == 4)
			return true;
		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 5; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else if (GameAction.ChessBox[x_temp1][y_temp1] == 3 - black_or_white)
				num2--;
			else
				break;
		}
		if (num2 == 4)
			return true;
		if (num1 + num2 > max_temp)
			max_temp = num1 + num2;
		max_num = max_temp;
		if (max_num > 3)
			return true;
		return false;
	}

	// 判断连断四类型
	boolean lian_duan_si(int x, int y, int black_or_white) {
		int x_temp = x, y_temp = y;
		// judeg left
		if (x_temp <= width - 5 && x_temp >= 0)
			if (GameAction.ChessBox[x_temp + 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp + 4][y_temp] == black_or_white)
				return true;
		// judge right
		if (x_temp <= width - 5 && x_temp >= 4)
			if (GameAction.ChessBox[x_temp - 1][y_temp] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp] == black_or_white
					&& GameAction.ChessBox[x_temp - 4][y_temp] == black_or_white)
				return true;
		// judeg up
		if (y_temp <= width - 5 && y_temp >= 0)
			if (GameAction.ChessBox[x_temp][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 3] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp + 4] == black_or_white)
				return true;
		// judge down
		if (y_temp <= width - 5 && y_temp >= 4)
			if (GameAction.ChessBox[x_temp][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 3] == black_or_white
					&& GameAction.ChessBox[x_temp][y_temp - 4] == black_or_white)
				return true;

		// judge U_L
		if (x_temp <= width - 5 && x_temp >= 0 && y_temp <= width - 5
				&& y_temp >= 0)
			if (GameAction.ChessBox[x_temp + 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp + 3] == black_or_white
					&& GameAction.ChessBox[x_temp + 4][y_temp + 4] == black_or_white)
				return true;
		// judge D_L
		if (x_temp <= width - 5 && x_temp >= 0 && y_temp <= width - 5
				&& y_temp >= 4)
			if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp + 2][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp + 3][y_temp - 3] == black_or_white
					&& GameAction.ChessBox[x_temp + 4][y_temp - 4] == black_or_white)
				return true;
		// judge U_R
		if (x_temp <= width - 5 && x_temp >= 4 && y_temp <= width - 5
				&& y_temp >= 0)
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp + 2] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp + 3] == black_or_white
					&& GameAction.ChessBox[x_temp - 4][y_temp + 4] == black_or_white)
				return true;
		// judge D_R
		if (x_temp <= width - 5 && x_temp >= 4 && y_temp <= width - 5
				&& y_temp >= 4)
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == 0
					&& GameAction.ChessBox[x_temp - 2][y_temp - 2] == black_or_white
					&& GameAction.ChessBox[x_temp - 3][y_temp - 3] == black_or_white
					&& GameAction.ChessBox[x_temp - 4][y_temp - 4] == black_or_white)
				return true;
		return false;
	}

	boolean duan_lian_si(int x, int y, int black_or_white) {
		int num1 = 0, max_temp = 0, num2 = 0, i;
		int x_temp = x, y_temp = y;
		int x_temp1 = x_temp, y_temp1 = y_temp;
		// judge right
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			if (x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else
				break;
		}
		// judge left
		x_temp1 = x_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			if (x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else
				break;
		}
		max_temp = num1 + num2;
		if (max_temp >= 4)
			return true;

		// judge up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			y_temp1 -= 1;
			if (y_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else
				break;
		}
		// judge down
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			y_temp1 += 1;
			if (y_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else
				break;
		}
		max_temp = num1 + num2;
		if (max_temp >= 4)
			return true;

		// judge left_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else
				break;
		}
		// judge right_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else
				break;
		}
		max_temp = num1 + num2;
		if (max_temp >= 4)
			return true;

		// judge right_up
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		num1 = 0;
		num2 = 0;
		for (i = 1; i < 4; i++) {
			x_temp1 += 1;
			y_temp1 -= 1;
			if (y_temp1 < 0 || x_temp1 >= width)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num1++;
			else
				break;
		}
		// judge left_down
		x_temp1 = x_temp;
		y_temp1 = y_temp;
		for (i = 1; i < 4; i++) {
			x_temp1 -= 1;
			y_temp1 += 1;
			if (y_temp1 >= width || x_temp1 < 0)
				break;
			if (GameAction.ChessBox[x_temp1][y_temp1] == black_or_white)
				num2++;
			else
				break;
		}
		max_temp = num1 + num2;
		if (max_temp >= 4)
			return true;
		return false;
	}

	boolean zhouwei3(int x, int y, int black_or_white) {
		int x_temp = x, y_temp = y, num1 = 0, num2 = 0;
		if (x_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (y_temp >= 1) {
			if (GameAction.ChessBox[x_temp][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (num2 - num1 >= 3)
			return true;
		return false;
	}

	boolean zhouwei2(int x, int y, int black_or_white) {
		int x_temp = x, y_temp = y, num1 = 0, num2 = 0;
		if (x_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (y_temp >= 1) {
			if (GameAction.ChessBox[x_temp][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (num2 - num1 >= 2)
			return true;
		return false;
	}

	boolean zhouwei1(int x, int y, int black_or_white) {
		int x_temp = x, y_temp = y, num1 = 0, num2 = 0;
		if (x_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp] == 3 - black_or_white)
				num2++;
		}
		if (y_temp >= 1) {
			if (GameAction.ChessBox[x_temp][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp >= 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp + 1][y_temp - 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp >= 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp - 1][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (x_temp < width - 1 && y_temp < width - 1) {
			if (GameAction.ChessBox[x_temp + 1][y_temp + 1] == black_or_white)
				num1++;
			else if (GameAction.ChessBox[x_temp][y_temp + 1] == 3 - black_or_white)
				num2++;
		}
		if (num2 - num1 >= 1)
			return true;
		return false;
	}

}