public class TestFloyd {
	// private int jarak[][];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int jarak_bobot_graph[][] = new int[5][5];
		int sebelum_predecessor_pendahulu[][] = new int[5][5];
		
		String asal[] = new String[] { "0", "1", "2", "3", "4" };
		String tujuan[] = new String[] { "0", "1", "2", "3", "4" };

		jarak_bobot_graph[0][1] = 3;
		jarak_bobot_graph[0][2] = 8;
		jarak_bobot_graph[0][4] = 4;
		jarak_bobot_graph[1][3] = 1;
		jarak_bobot_graph[1][4] = 7;
		jarak_bobot_graph[2][1] = 4;
		jarak_bobot_graph[3][0] = 2;
		jarak_bobot_graph[3][2] = 5;
		jarak_bobot_graph[4][3] = 6;

		System.out.println("jarak atau bobot graph");
		for (int a = 0; a < n; a++) {
			System.out.print(" " + tujuan[a]);
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(asal[i] + " ");
			for (int j = 0; j < n; j++) {
				System.out.print(jarak_bobot_graph[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (jarak_bobot_graph[i][j] != 0) {
					sebelum_predecessor_pendahulu[i][j] = (i + 1);
				} else {
					sebelum_predecessor_pendahulu[i][j] = 0;
				}
			}
		}

		System.out.println("sebelum_predecessor_pendahulu");
		for (int a = 0; a < n; a++) {
			System.out.print(" " + tujuan[a]);
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(asal[i] + " ");
			for (int j = 0; j < n; j++) {
				System.out.print(sebelum_predecessor_pendahulu[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		/*
		 * floyd_warshall() after calling this function dist[i][j] will the the
		 * minimum distance between i and j if it exists (i.e. if there's a path
		 * between i and j) or 0, otherwise
		 */
		System.out
				.println("graph tidak langsung atau melewati minimal 1 titik transit");

		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					/*
					 * If i and j are different nodes and if the paths between i
					 * and k and between k and j exist, do
					 */
					if ((jarak_bobot_graph[i][k] * jarak_bobot_graph[k][j] != 0)
							&& (i != j)) {
						/*
						 * See if you can't get a shorter path between i and j
						 * by interspacing k somewhere along the current path
						 */
						if ((jarak_bobot_graph[i][k] + jarak_bobot_graph[k][j] < jarak_bobot_graph[i][j])
								|| (jarak_bobot_graph[i][j] == 0)) {
							jarak_bobot_graph[i][j] = jarak_bobot_graph[i][k]
									+ jarak_bobot_graph[k][j];
							sebelum_predecessor_pendahulu[i][j] = sebelum_predecessor_pendahulu[k][j];
							System.out
									.println("jarak dari "
											+ (i + 1)
											+ " ke "
											+ (j + 1)
											+ "= "
											+ jarak_bobot_graph[i][j]
											+ ", dan titik yang dilewati sebelum titik "
											+ (j + 1)
											+ " adalah titik "
											+ sebelum_predecessor_pendahulu[i][j]);
						}
					}
				}
			}
		}
		System.out.println("");

		System.out
				.println("Hasil jarak atau bobot graph terpendek dari titik awal ke tujuan");
		for (int a = 0; a < n; a++) {
			System.out.print(" " + tujuan[a]);
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(asal[i] + " ");
			for (int j = 0; j < n; j++) {
				System.out.print(jarak_bobot_graph[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		System.out
				.println("Hasil sebelum_predecessor_pendahulu yang digunakan untuk mengetahui jalur/rute nya");
		for (int a = 0; a < n; a++) {
			System.out.print(" " + tujuan[a]);
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(asal[i] + " ");
			for (int j = 0; j < n; j++) {
				System.out.print(sebelum_predecessor_pendahulu[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		// jalurnya(sebelum_predecessor_pendahulu,4,1);

		int i = 4;
		int j = 1;
		int k;
		System.out.println("titik tujuan " + (j + 1));
		System.out.println("dengan jarak terpendek " + jarak_bobot_graph[i][j]);
		do {
			k = sebelum_predecessor_pendahulu[i][j];
			System.out.println("rute dari titik " + (i + 1) + " menuju titik "
					+ (j + 1) + " melewati titik " + k);
			j = (k - 1);
		} while (i != j);

		// while(i!=j){
		// k = sebelum_predecessor_pendahulu[i][j];
		// System.out.println("rute2 dari "+(i+1)+" menuju "+(j+1)+" melewati titik "+k);
		// j=(k-1);
		// }

	}

}
