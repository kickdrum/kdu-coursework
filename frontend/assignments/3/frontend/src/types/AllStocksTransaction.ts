export interface StocksTransactions {
  company: string;
  symbol: string;
  data: Datum[];
}

export interface Datum {
  date: Date;
  prices: number[];
}
