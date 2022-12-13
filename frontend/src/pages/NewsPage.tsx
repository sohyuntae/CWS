import {
  Button,
  Card,
  CardActionArea,
  CardActions,
  CardContent,
  CardMedia,
  CircularProgress,
  Divider,
  Grid,
  IconButton,
  InputBase,
  Paper,
  styled,
  TextField,
  Typography,
} from "@mui/material";
import { useRecoilValueLoadable } from "recoil";
import iNews from "../assets/interfaces/iNews";
import { newsSelectorFamily } from "../assets/states/news";
import MenuIcon from "@mui/icons-material/Menu";
import SearchIcon from "@mui/icons-material/Search";
import { useState } from "react";

const NewsPage = () => {
  const [query, setQuery] = useState<string>();
  const [keyword, setKeyword] = useState<string>();
  const { state, contents } = useRecoilValueLoadable(newsSelectorFamily(query!));

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.target.value;
    setKeyword(value);
  };

  const handleClick = () => {
    if (!keyword) {
      return;
    } else {
      setQuery(keyword);
    }
  };

  return (
    <div>
      <Typography variant="h4" align="center" gutterBottom>
        News
      </Typography>
      <Paper component="div" sx={{ p: "2px 4px", display: "flex", alignItems: "center", width: 400, m: "20px auto" }}>
        {/* <IconButton sx={{ p: "10px" }} aria-label="menu">
          <MenuIcon />
        </IconButton> */}
        <InputBase
          id="query"
          sx={{ ml: 1, flex: 1 }}
          inputProps={{ "aria-label": "search keyword" }}
          placeholder="search keyword"
          value={keyword}
          onChange={handleChange}
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
          contents.articles.map((data: iNews, index: number) => (
            <Grid xs={12} sm={6} lg={3} key={index} item={true}>
              <Card>
                <a href={data.url} target="_blank">
                  <CardActionArea>
                    <CardMedia component="img" height="140" image={data.urlToImage} />
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
                      {/* <Typography variant="body2" color="text.secondary">
                        {data.description}
                      </Typography> */}
                    </CardContent>
                  </CardActionArea>
                </a>
                {/* <CardActions>
                  <Button size="small" color="primary">
                    Share
                  </Button>
                </CardActions> */}
              </Card>
            </Grid>
          ))}
      </Grid>
    </div>
  );
};

export default NewsPage;
