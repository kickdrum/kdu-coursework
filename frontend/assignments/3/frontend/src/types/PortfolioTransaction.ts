export interface PortfolioStockTransactions {
  stock_name: StockName | string;
  stock_symbol: StockSymbol | string;
  transaction_price: number;
  timestamp: string;
  status: Status;
}

export enum Status {
  Failed = "Failed",
  Passed = "Passed",
}

export enum StockName {
  BakerSmith = "Baker-Smith",
  BellWaller = "Bell-Waller",
  FordAndSons = "Ford and Sons",
  GrayLtd = "Gray Ltd",
  HernandezTaylor = "Hernandez-Taylor",
  LEAndSons = "Le and Sons",
  LEBakerAndRoberts = "Le, Baker and Roberts",
  MclaughlinJonesAndJones = "Mclaughlin, Jones and Jones",
  MillerHernandezAndThomas = "Miller, Hernandez and Thomas",
  MillerWright = "Miller-Wright",
  MorganPLC = "Morgan PLC",
  NelsonAndSons = "Nelson and Sons",
  NovakAndSons = "Novak and Sons",
  OwensErickson = "Owens-Erickson",
  PalmerWood = "Palmer-Wood",
  RossMuellerAndWalker = "Ross, Mueller and Walker",
  SmithRivera = "Smith-Rivera",
  StuartJonesAndWhite = "Stuart, Jones and White",
  WheelerKellyAndLucas = "Wheeler, Kelly and Lucas",
  WrightRoss = "Wright-Ross",
}

export enum StockSymbol {
  Bak = "BAK",
  Bel = "BEL",
  For = "FOR",
  Gra = "GRA",
  Her = "HER",
  LE = "LE,",
  Mcl = "MCL",
  Mil = "MIL",
  Mor = "MOR",
  Nel = "NEL",
  Nov = "NOV",
  Owe = "OWE",
  Pal = "PAL",
  Ros = "ROS",
  Smi = "SMI",
  StockSymbolLE = "LE ",
  Stu = "STU",
  Whe = "WHE",
  Wri = "WRI",
}
