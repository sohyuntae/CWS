import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";

import { menus } from "../assets/data/menus";
import Drawer from "../components/Drawer";
import { Container } from "@mui/material";

interface Props {
  window?: () => Window;
  children?: React.ReactNode;
}

export default function MainLayout(props: Props) {
  const { window } = props;
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };

  return (
    <Box>
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
            {menus.map((menu) => (
              <Link to={menu.link}>
                <Button key={menu.name} sx={{ color: "#fff" }}>
                  {menu.name}
                </Button>
              </Link>
            ))}
          </Box>
        </Toolbar>
      </AppBar>
      <Box component="nav">
        <Drawer window={window} menus={menus} mobileOpen={mobileOpen} handleDrawerToggle={handleDrawerToggle} />
      </Box>
      <Box component="main" sx={{ p: 3 }}>
        <Toolbar />
        <Typography>
          <Container>{props.children}</Container>
        </Typography>
      </Box>
    </Box>
  );
}
