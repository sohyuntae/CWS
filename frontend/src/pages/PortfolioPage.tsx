import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import Grid from "@mui/material/Unstable_Grid2";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import { Button, CardActionArea, CardActions } from "@mui/material";
import img from "../assets/images/google.png";

function PortfolioPage() {
  return (
    <div>
      <Typography variant="h4" align="center" gutterBottom>
        Portfolio
      </Typography>

      <Grid container spacing={2}>
        <Grid xs={6} md={3}>
          <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
              <CardMedia component="img" height="140" image={img} alt="green iguana" />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  프로젝트1
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  프로젝트1 설명
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions>
              <Button size="small" color="primary">
                Share
              </Button>
            </CardActions>
          </Card>
        </Grid>
        <Grid xs={6} md={3}>
          <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
              <CardMedia component="img" height="140" image={img} alt="green iguana" />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  프로젝트2
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  프로젝트2 설명
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions>
              <Button size="small" color="primary">
                Share
              </Button>
            </CardActions>
          </Card>
        </Grid>
        <Grid xs={6} md={3}>
          <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
              <CardMedia component="img" height="140" image={img} alt="green iguana" />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  프로젝트3
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  프로젝트3 설명
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions>
              <Button size="small" color="primary">
                Share
              </Button>
            </CardActions>
          </Card>
        </Grid>
        <Grid xs={6} md={3}>
          <Card sx={{ maxWidth: 345 }}>
            <CardActionArea>
              <CardMedia component="img" height="140" image={img} alt="green iguana" />
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  프로젝트4
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  프로젝트4 설명
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions>
              <Button size="small" color="primary">
                Share
              </Button>
            </CardActions>
          </Card>
        </Grid>
      </Grid>
    </div>
  );
}

export default PortfolioPage;
