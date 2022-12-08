import { AppBar, Box, Button, IconButton, Toolbar, Typography } from "@mui/material";
import { Link } from "react-router-dom";
import iMenu from "../assets/interfaces/iMenu";
import MenuIcon from "@mui/icons-material/Menu";

interface Props {
  menus: Array<iMenu>;
  handleDrawerToggle: () => void;
}

export default function Header(props: Props) {
  const { menus, handleDrawerToggle } = props;
  return (
    <AppBar component="nav">
      <Toolbar>
        <IconButton
          color="inherit"
          aria-label="open drawer"
          edge="start"
          onClick={handleDrawerToggle}
          sx={{ mr: 2, display: { sm: "none" } }}
        >
          <MenuIcon />
        </IconButton>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          CWS
        </Typography>
        <Box sx={{ display: { xs: "none", sm: "block" } }}>
          {menus.map((menu, index) => (
            <Link to={menu.link} key={index}>
              <Button key={menu.name} sx={{ color: "#fff" }}>
                {menu.name}
              </Button>
            </Link>
          ))}
        </Box>
      </Toolbar>
    </AppBar>
  );
}
