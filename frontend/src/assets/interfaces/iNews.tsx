interface iSource {
  id: string;
  name: string;
}

export default interface iNews {
  source: iSource;
  author: string;
  title: string;
  description: string;
  url: string;
  urlToImage: string;
  publishedAt: Date;
  content: string;
}
