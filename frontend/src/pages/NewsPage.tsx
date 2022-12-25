import {
  Card,
  CardActionArea,
  CardContent,
  CardMedia,
  CircularProgress,
  Grid,
  IconButton,
  InputBase,
  Paper,
  Typography,
} from "@mui/material";
import { useRecoilValueLoadable } from "recoil";
import iNews from "../assets/interfaces/iNews";
import { newsSelectorFamily } from "../assets/states/news";
import SearchIcon from "@mui/icons-material/Search";
import { useRef, useState } from "react";

const NewsPage = () => {
  const [params, setParams] = useState<any>({
    q: "java",
  });
  const inputRef = useRef<HTMLInputElement>();
  const { state, contents } = useRecoilValueLoadable(newsSelectorFamily(params!));

  const handleClick = () => {
    const keyword = inputRef.current!.value;
    if (!keyword) {
      return;
    } else {
      setParams({ ...params, q: keyword });
    }
  };

  return (
    <div>
      <Typography variant="h4" align="center" gutterBottom>
        News
      </Typography>
      <Paper component="div" sx={{ p: "2px 4px", display: "flex", alignItems: "center", width: 400, m: "20px auto" }}>
        <InputBase
          sx={{ ml: 1, flex: 1 }}
          inputProps={{ "aria-label": "search keyword" }}
          placeholder="search keyword"
          inputRef={inputRef}
        />
        <IconButton type="button" sx={{ p: "10px" }} aria-label="search" onClick={handleClick}>
          <SearchIcon />
        </IconButton>
      </Paper>
      <Grid container spacing={2}>
        {state === "loading" && (
          <div style={{ textAlign: "center", width: "100%", margin: "20px 0" }}>
            <CircularProgress />
          </div>
        )}
        {state === "hasError" && <p>뉴스가 없습니다.</p>}
        {state === "hasValue" &&
          (contents.articles.length > 0 ? (
            contents.articles.map((data: iNews, index: number) => (
              <Grid xs={12} sm={6} lg={3} key={index} item={true}>
                <Card>
                  <a href={data.url} target="_blank">
                    <CardActionArea>
                      <CardMedia
                        component="img"
                        height="140"
                        image={data.urlToImage}
                        onError={(e) => {
                          const target = e.target as HTMLImageElement;
                          target.src = "/logo512.png";
                        }}
                      />
                      <CardContent>
                        <Typography
                          gutterBottom
                          variant="h5"
                          component="div"
                          style={{
                            display: "-webkit-box",
                            WebkitLineClamp: 2,
                            WebkitBoxOrient: "vertical",
                            overflow: "hidden",
                          }}
                        >
                          {data.title}
                        </Typography>
                      </CardContent>
                    </CardActionArea>
                  </a>
                </Card>
              </Grid>
            ))
          ) : (
            <p>뉴스가 없습니다.</p>
          ))}
      </Grid>
    </div>
  );
};

export default NewsPage;
