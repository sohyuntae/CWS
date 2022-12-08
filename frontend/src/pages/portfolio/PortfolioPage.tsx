import Typography from "@mui/material/Typography";
import Grid from "@mui/material/Unstable_Grid2";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import { Button, CardActionArea, CardActions, CircularProgress } from "@mui/material";
import { Link } from "react-router-dom";
import { useRecoilValueLoadable } from "recoil";
import { portfolioSelector } from "../../assets/states/portfolio";
import { useEffect } from "react";
import iPortfolio from "../../assets/interfaces/iPortfolio";

function PortfolioPage() {
  const { state, contents } = useRecoilValueLoadable(portfolioSelector);
  return (
    <div>
      <Typography variant="h4" align="center" gutterBottom>
        Portfolio
      </Typography>

      <Grid container spacing={2}>
        {state === "loading" && <CircularProgress />}
        {state === "hasError" && <p>포트폴리오가 없습니다.</p>}
        {state === "hasValue" &&
          contents.map((portfolio: iPortfolio) => (
            <Grid xs={12} sm={6} lg={3} key={portfolio.id}>
              <Card>
                <Link to={`/portfolio/${portfolio.id}`}>
                  <CardActionArea>
                    <CardMedia component="img" height="140" image={portfolio.thumbnail} alt="green iguana" />
                    <CardContent>
                      <Typography gutterBottom variant="h5" component="div">
                        {portfolio.title}
                      </Typography>
                      <Typography variant="body2" color="text.secondary">
                        {portfolio.description}
                      </Typography>
                    </CardContent>
                  </CardActionArea>
                </Link>
                <CardActions>
                  <Button size="small" color="primary">
                    Share
                  </Button>
                </CardActions>
              </Card>
            </Grid>
          ))}
      </Grid>
    </div>
  );
}

export default PortfolioPage;
