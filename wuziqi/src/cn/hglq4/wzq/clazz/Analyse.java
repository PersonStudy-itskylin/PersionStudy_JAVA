package cn.hglq4.wzq.clazz;

//人工智能类，按照前面讨论的算法，搜索最佳落子位置
public class Analyse {

	int STEPCOUNTER = 0;
	int BASE = 5;
	int DEEPTH = 3;
	int MINDEEPTH = 3;
	int MAX1 = 5;
	long INVALID = 9000000;
	int chessBoard[][];

	public int cx, cy;

	// 构造函数
	public Analyse(int chessc[][]) {
		int i, j;
		chessBoard = new int[19][19];
		for (i = 0; i <= 18; i++) {
			for (j = 0; j <= 18; j++) {
				if (i == 0 || j == 0 || i == 18 || j == 18) {
					chessBoard[i][j] = 4;
				} else {
					chessBoard[i][j] = chessc[i - 1][j - 1];
				}
			}
		}
	}

	private long pow(int base, int pow) {
		int i;
		long result = 1;
		for (i = 1; i <= pow; i++) {
			result *= base;
		}
		return result;
	}

	/**
	 * 判断上下位置
	 */
	private long analyseUd(int x, int y, int side) {
		int tt[][] = new int[19][19];
		int i, j;
		int tempx, tempy;
		long mark = 0;
		int base = BASE;// 初值不知道？？？？
		int uppersign = 0;
		int downsign = 0;
		int c_count = 1;

		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				tt[i][j] = chessBoard[i][j];
			}
		}
		tt[y][x] = side;
		tempx = x;
		tempy = y;
		if (tt[tempy - 1][tempx] != side) {
			if (tt[tempy - 1][tempx] == 0) {
				uppersign = 1;
			}
			if (tt[tempy - 1][tempx] != 0) {
				uppersign = 0;
			}
		} else {
			tempy -= 1;
			while (tt[tempy][tempx] == side) {
				c_count += 1;
				tempy--;
			}
			if (tt[tempy][tempx] == 0) {
				uppersign = 1;
			}
			if (tt[tempy][tempx] != 0) {
				uppersign = 0;
			}
		}
		tempx = x;
		tempy = y;
		if (tt[tempy + 1][tempx] != side) {
			if (tt[tempy + 1][tempx] == 0) {
				downsign = 1;
			}
			if (tt[tempy + 1][tempx] != 0) {
				downsign = 0;
			}
		} else {
			tempy += 1;
			while (tt[tempy][tempx] == side) {
				c_count += 1;
				tempy++;
			}
			if (tt[tempy][tempx] == 0) {
				downsign = 1;
			}
			if (tt[tempy][tempx] != 0) {
				downsign = 0;
			}
		}
		mark += pow(base, c_count);
		if ((uppersign + downsign) > 0) {
			if ((uppersign + downsign) == 2) {
				mark *= (uppersign + downsign);
			}
			if ((uppersign + downsign) == 1) {
				mark = mark / 2;
			}
		} else if (c_count == 5) {
			mark *= 4;
		} else {
			mark = 0;
		}
		if (c_count == 5) {
			mark += INVALID;
		}
		return mark;
	}

	/**
	 * 判断左右位置
	 */
	private long analyseLr(int x, int y, int side) {
		int tt[][] = new int[19][19];
		int i, j, tx, ty;
		long mark = 0;

		int base = BASE, uppersign = 0, downsign = 0, c_count = 1;
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				tt[i][j] = chessBoard[i][j];
			}
		}
		tt[y][x] = side;
		tx = x;
		ty = y;
		if (tt[ty][tx - 1] != side) {
			if (tt[ty][tx - 1] == 0) {
				uppersign = 1;
			}
			if (tt[ty][tx - 1] != 0) {
				uppersign = 0;
			}
		} else {
			tx -= 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx--;
			}
			if (tt[ty][tx] == 0) {
				uppersign = 1;
			}
			if (tt[ty][tx] != 0) {
				uppersign = 0;
			}
		}
		tx = x;
		ty = y;
		if (tt[ty][tx + 1] != side) {
			if (tt[ty][tx + 1] == 0) {
				downsign = 1;
			}
			if (tt[ty][tx + 1] != 0) {
				downsign = 0;
			}
		} else {
			tx += 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx++;
			}
			if (tt[ty][tx] == 0) {
				downsign = 1;
			}
			if (tt[ty][tx] != 0) {
				downsign = 0;
			}
		}
		mark += pow(base, c_count);
		if ((uppersign + downsign) > 0) {
			if ((uppersign + downsign) == 2) {
				mark *= (uppersign + downsign);
			}
			if ((uppersign + downsign) == 1) {
				mark = mark / 2;
			}
		} else if (c_count == 5) {
			mark *= 4;
		} else {
			mark = 0;
		}
		if (c_count == 5) {
			mark += INVALID;
		}
		return mark;
	}

	/**
	 * 判断右上到左下的斜线位置
	 */
	private long analyseLdru(int x, int y, int side) {
		int tt[][] = new int[19][19];
		int i, j;
		int tx, ty;
		long mark = 0;

		int base = BASE;
		int uppersign = 0;
		int downsign = 0;
		int c_count = 1;
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				tt[i][j] = chessBoard[i][j];
			}
		}
		tt[y][x] = side;
		tx = x;
		ty = y;
		if (tt[ty - 1][tx - 1] != side) {
			if (tt[ty - 1][tx - 1] == 0) {
				uppersign = 1;
			}
			if (tt[ty - 1][tx - 1] != 0) {
				uppersign = 0;
			}
		} else {
			tx -= 1;
			ty -= 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx--;
				ty--;
			}
			if (tt[ty][tx] == 0) {
				uppersign = 1;
			}
			if (tt[ty][tx] != 0) {
				uppersign = 0;
			}
		}
		tx = x;
		ty = y;
		if (tt[ty + 1][tx + 1] != side) {
			if (tt[ty + 1][tx + 1] == 0) {
				downsign = 1;
			}
			if (tt[ty + 1][tx + 1] != 0) {
				downsign = 0;
			}
		} else {
			tx += 1;
			ty += 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx++;
				ty++;
			}
			if (tt[ty][tx] == 0) {
				downsign = 1;
			}
			if (tt[ty][tx] != 0) {
				downsign = 0;
			}
		}
		mark += pow(base, c_count);
		if ((uppersign + downsign) > 0) {
			if ((uppersign + downsign) == 2) {
				mark *= (uppersign + downsign);
			}
			if ((uppersign + downsign) == 1) {
				mark = mark / 2;
			}
		} else if (c_count == 5) {
			mark *= 4;
		} else {
			mark = 0;
		}
		if (c_count == 5) {
			mark += INVALID;
		}
		return mark;
	}

	/**
	 * 判断左上到右下的斜线位置
	 */
	private long analyseRdlu(int x, int y, int side) {
		int tt[][] = new int[19][19];
		int i, j;
		int tx, ty;
		long mark = 0;

		int base = BASE;
		int uppersign = 0;
		int downsign = 0;
		int c_count = 1;
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 19; j++) {
				tt[i][j] = chessBoard[i][j];
			}
		}
		tt[y][x] = side;
		tx = x;
		ty = y;
		if (tt[ty - 1][tx + 1] != side) {
			if (tt[ty - 1][tx + 1] == 0) {
				uppersign = 1;
			}
			if (tt[ty - 1][tx + 1] != 0) {
				uppersign = 0;
			}
		} else {
			tx += 1;
			ty -= 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx++;
				ty--;
			}
			if (tt[ty][tx] == 0) {
				uppersign = 1;
			}
			if (tt[ty][tx] != 0) {
				uppersign = 0;
			}
		}
		tx = x;
		ty = y;
		if (tt[ty + 1][tx - 1] != side) {
			if (tt[ty + 1][tx - 1] == 0) {
				downsign = 1;
			}
			if (tt[ty + 1][tx - 1] != 0) {
				downsign = 0;
			}
		} else {
			tx -= 1;
			ty += 1;
			while (tt[ty][tx] == side) {
				c_count += 1;
				tx--;
				ty++;
			}
			if (tt[ty][tx] == 0) {
				downsign = 1;
			}
			if (tt[ty][tx] != 0) {
				downsign = 0;
			}
		}
		mark += pow(base, c_count);
		if ((uppersign + downsign) > 0) {
			if ((uppersign + downsign) == 2) {
				mark *= (uppersign + downsign);
			}
			if ((uppersign + downsign) == 1) {
				mark = mark / 2;
			}
		} else if (c_count == 5) {
			mark *= 4;
		} else {
			mark = 0;
		}
		if (c_count == 5) {
			mark += INVALID;
		}
		return mark;
	}

	/**
	 * 调用4个分析方法，返回最后的分析结果
	 */
	private long analyse(int x, int y, int side) {
		long mark = 0;
		mark += analyseUd(x, y, side);
		mark += analyseLr(x, y, side);
		mark += analyseLdru(x, y, side);
		mark += analyseRdlu(x, y, side);
		return mark;
	}

	/**
	 * 
	 * 寻找最优落子位置
	 */
	private Queue searchPoint(int chess[][], int deepth) {
		Queue pq[] = null, pq_temp[] = null, pq_final;
		int temp_chess[][] = new int[19][19];
		long mark = 0;
		int i, j;
		int m, n, p, q;
		int media;
		int MAX;

		MAX = MAX1 <= (225 - STEPCOUNTER) ? MAX1 : (225 - STEPCOUNTER);
		if (MAX == (225 - STEPCOUNTER)) {
			MINDEEPTH = 1;
		}
		pq = new Queue[MAX + 1];
		for (m = 0; m < MAX; m++) {
			pq[m] = new Queue();
			pq[m].mark = 0;
			pq[m].position = 0;
		}
		for (i = 1; i <= 15; i++) {
			for (j = 1; j <= 15; j++) {
				if (chess[i][j] != 0) {
					mark = 0;
				} else {
					mark = analyse(j, i, 1) / 2 + analyse(j, i, 2); // 333333333333
				}

				// 从大到小排序
				for (m = 0; m < MAX; m++) {
					if (mark > pq[m].mark) {
						for (n = MAX - 1; n > m; n--) {
							pq[n].mark = pq[n - 1].mark;
							pq[n].position = pq[n - 1].position;
						}
						pq[m].mark = mark;
						pq[m].position = i * 100 + j;
						break;
					}
				}
			}
		}
		if (pq[0].mark >= INVALID / 2) {
			MINDEEPTH = deepth;
		}
		if (deepth < MINDEEPTH) {
			for (m = 0; m < MAX; m++) {
				for (p = 0; p <= 18; p++) {
					for (q = 0; q <= 18; q++) {
						temp_chess[p][q] = chess[p][q];
					}
				}
				if (deepth % 2 == 1) {
					media = 2;
				} else {
					media = 1;
				}
				temp_chess[pq[m].position / 100][pq[m].position % 100] = media;
				pq[m] = searchPoint(temp_chess, deepth + 1);
			}
		}
		pq_temp = new Queue[MAX + 1];
		for (m = 0; m < MAX; m++) {
			pq_temp[m] = new Queue();
		}

		for (p = 0; p < MAX; p++) {
			pq_temp[p].mark = 0;
			pq_temp[p].position = 0;
		}
		for (p = 0; p < MAX; p++) {
			for (q = 0; q < MAX; q++) {
				if (pq[p].mark > pq_temp[q].mark) {
					for (i = MAX - 1; i > q; i--) {
						pq_temp[i] = pq_temp[i - 1];
					}
					pq_temp[q] = pq[p];
					break;
				}
			}
		}
		pq_final = pq_temp[0];
		return pq_final;
	}

	public int computerDo() {
		int position = 0;
		position = (searchPoint(chessBoard, 3)).position;
		cx = position % 100;
		cy = position / 100;
		if (cx == 0 && cy == 0) {
			return 1;
		}
		return position;
	}
}

class Queue {
	int position;
	long mark;
}
